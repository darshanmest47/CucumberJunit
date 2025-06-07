package com.testUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverFactory() {
        // private constructor to prevent instantiation
    }

    // Initialize driver based on browser name (called per thread)
    public static void setDriver(String browserName) throws Exception {
        WebDriver driver = null;

        if (browserName == null) {
            throw new Exception("Browser name is null!");
        }

        switch (browserName.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                // You can add more options here if needed
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                // You can add more options here if needed
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                // You can add more options here if needed
                driver = new EdgeDriver();
                break;

            default:
                throw new Exception("Unsupported browser: " + browserName);
        }

        driverThreadLocal.set(driver);
    }

    // Get the driver for current thread
    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    // Quit the driver and remove it from ThreadLocal for current thread
    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
