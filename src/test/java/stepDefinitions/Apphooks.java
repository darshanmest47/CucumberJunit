package stepDefinitions;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.testUtilities.DriverFactory;
import com.tests.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Apphooks {
    @Before(order = 0)
    public void setUp() throws Exception {
        BaseTest.getInstance().initializeMethod();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) throws Throwable {
    	if(scenario.isFailed()) {
        	File folder = new File("./FailedScreenShots");
        	if(folder.exists()) {
        		FileUtils.deleteDirectory(folder);
        	}else {
        		WebDriver driver = DriverFactory.getDriver();
        		TakesScreenshot ts = ((TakesScreenshot)driver);
        		File src = ts.getScreenshotAs(OutputType.FILE);
        		File dest = new File("./FailedScreenShots/"+scenario.getName()+".png");
        		FileUtils.copyFile(src, dest);
        	}
    	}

        BaseTest.getInstance().quitMethod();
    }
}
