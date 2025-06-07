package stepDefinitions;

import POM.PageObjects;
import com.testUtilities.DriverFactory;
import Utilities.ExcelReader;
import Utilities.PropertyReader;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected ExcelReader excelReader;
    protected PropertyReader propertyReader;
    protected PageObjects pageObjects = null;

    public BaseStep() throws Exception {
        driver = DriverFactory.getDriver();
        excelReader = ExcelReader.getInstance();
        propertyReader = PropertyReader.getInstance();
        pageObjects = new PageObjects(this.driver);
    }
}
