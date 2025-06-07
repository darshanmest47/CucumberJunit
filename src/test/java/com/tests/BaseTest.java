package com.tests;

import com.testUtilities.DriverFactory;
import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    private BaseTest() {}

    private static BaseTest instance = null;

    public static synchronized BaseTest getInstance() {
        if (instance == null) {
            instance = new BaseTest();
        }
        return instance;
    }

    public void initializeMethod() throws Exception {
        String browser = PropertyReader.getInstance().getProperty("BROWSER");
        DriverFactory.setDriver(browser);  // initializes ThreadLocal driver for current thread

        WebDriver driver = DriverFactory.getDriver();  // get driver for this thread
        String url = PropertyReader.getInstance().getProperty("TESTURL");
        driver.get(url);
    }

    public void quitMethod() {
        DriverFactory.quitDriver();  // quits and removes driver for this thread
    }
}
