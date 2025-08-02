package stepDefinitions; // Make sure this matches your glue package

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver; // Assuming you have a way to get your WebDriver instance

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportHooks extends BaseStep {

    private static ExtentReports extent;
    // Use ThreadLocal to manage ExtentTest per thread for parallel execution if applicable
    private static ThreadLocal<ExtentTest> scenarioTest = new ThreadLocal<>();

    private static final String REPORT_DIR = "target/manual-ExtentReports/";
    private static String reportFileName;

    public ExtentReportHooks() throws Exception {
    }

    // A simple way to get WebDriver (you'll need to adapt this to your framework)
    // For example, if you have a WebDriverManager class
    // public static WebDriver driver; // You'd set this from your WebDriver setup
    // Or a method to get the current driver instance:
    // private static WebDriver getDriverInstance() {
    //     // Implement your method to get the current WebDriver instance for the thread
    //     // This is crucial for screenshots
    //     return YourWebDriverSetupClass.getDriver(); // Replace with your actual implementation
    // }

    @BeforeAll
    public static void setupReport() {
        // Create directory for reports if it doesn't exist
        new File(REPORT_DIR).mkdirs();

        // Generate a unique report filename with timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        reportFileName = "AutomationReport_" + timestamp + ".html";
        String fullReportPath = REPORT_DIR + reportFileName;

        // Initialize ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fullReportPath);

        // Load extent-config.xml if it exists
        File configFile = new File("src/test/resources/extent-config.xml");
        if (configFile.exists()) {
            try {
                sparkReporter.loadXMLConfig(configFile);
                System.out.println("Extent Report config loaded from: " + configFile.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error loading Extent Report config: " + e.getMessage());
                // Fallback to default if config fails
            }
        } else {
            System.out.println("extent-config.xml not found at " + configFile.getAbsolutePath() + ". Using default Extent Report configuration.");
        }

        // Initialize ExtentReports and attach the reporter
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add System Information
        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        System.out.println("Manual Extent Reports initialized at: " + fullReportPath);
    }

    @Before // Runs before each scenario
    public void beforeScenario(Scenario scenario) {
        // Create a new ExtentTest for each scenario
        ExtentTest test = extent.createTest(scenario.getName());
        scenarioTest.set(test); // Store it in ThreadLocal for access in other methods/steps
        System.out.println("Starting ExtentTest for scenario: " + scenario.getName());
    }

    @After // Runs after each scenario
    public void afterScenario(Scenario scenario) {
        ExtentTest currentTest = scenarioTest.get();

        if (currentTest != null) {
            // Log scenario status to Extent Report
            if (scenario.isFailed()) {
                currentTest.log(Status.FAIL, "Scenario Failed: " + scenario.getName());
                // Add screenshot on failure
                try {
                    // IMPORTANT: You need to get your WebDriver instance here
                    // Replace 'getDriverInstance()' with your actual method to retrieve the WebDriver
                    // This is just a placeholder!
                    //WebDriver driver = null; // <= Replace this line with your actual driver instance retrieval

                    // Example: If you have a static WebDriver in another class:
                    // driver = YourBaseClass.getDriver();
                    // Or if passed via PicoContainer/dependency injection for current thread:
                    // driver = testContext.getWebDriver(); etc.

                    if (driver instanceof TakesScreenshot) {
                        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                        String base64Screenshot = java.util.Base64.getEncoder().encodeToString(screenshot);
                        currentTest.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
                        // Also attach to Cucumber's native report for 'pretty' plugin
                        scenario.attach(screenshot, "image/png", scenario.getName());
                    } else {
                        currentTest.log(Status.FAIL, "WebDriver does not support screenshots.");
                    }
                } catch (Exception e) {
                    currentTest.log(Status.FAIL, "Failed to capture screenshot: " + e.getMessage());
                }
            } else if (scenario.getStatus().equals(io.cucumber.java.Status.SKIPPED)) {
                currentTest.log(Status.SKIP, "Scenario Skipped: " + scenario.getName());
            } else {
                currentTest.log(Status.PASS, "Scenario Passed: " + scenario.getName());
            }
        }
        scenarioTest.remove(); // Clean up ThreadLocal after scenario
        System.out.println("Finished ExtentTest for scenario: " + scenario.getName() + " - Status: " + scenario.getStatus());
    }

    @AfterAll
    public static void teardownReport() {
        if (extent != null) {
            extent.flush(); // IMPORTANT: This writes the report to the file
            System.out.println("Manual Extent Reports flushed. Report available at: " + REPORT_DIR + reportFileName);
        }
    }

    // Helper method to get the current ExtentTest instance for logging within Step Definitions
    public static ExtentTest getScenarioTest() {
        return scenarioTest.get();
    }
}