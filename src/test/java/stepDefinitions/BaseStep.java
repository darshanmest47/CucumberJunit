package stepDefinitions;

import POM.PageObjects;
import com.testUtilities.DriverFactory;
import Utilities.ExcelReader;
import Utilities.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class BaseStep {
    protected WebDriver driver;
    protected ExcelReader excelReader;
    protected PropertyReader propertyReader;
    protected PageObjects pageObjects = null;
    protected final Logger logger;

    public BaseStep() throws Exception {
        driver = DriverFactory.getDriver();
        excelReader = ExcelReader.getInstance();
        propertyReader = PropertyReader.getInstance();
        pageObjects = new PageObjects(this.driver);
        logger = (Logger) LogManager.getLogger(BaseStep.class);
    }
}
