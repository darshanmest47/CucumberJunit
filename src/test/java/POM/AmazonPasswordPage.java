package POM;

import com.testUtilities.ActionsHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.testUtilities.WaitUtilities.waitForVisibilityOfElementInSeconds;

public class AmazonPasswordPage extends BasePage {
    private ActionsHelperUtility actionsHelperUtility = null;

    public AmazonPasswordPage(WebDriver driver) {
        super(driver);
        actionsHelperUtility = ActionsHelperUtility.getInstance(driver);
    }

    @FindBy(css = "#auth-email-claim")
    private WebElement userName;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[contains(text(),'Enter your password')]")
    private WebElement passwordWarning;

    @FindBy(id = "signInSubmit")
    private WebElement submitButton;

    private WebElement getUserName() {
        return userName;
    }

    private WebElement getPasswordField() {
        return passwordField;
    }

    private WebElement getSubmitButton() {
        return submitButton;
    }

    private WebElement getPasswordWarning() {
        return passwordWarning;
    }

    public String getUserNameText() {
        waitForVisibilityOfElementInSeconds(getUserName(), 10);
        return getUserName().getText().trim();
    }

    public void enterPassword(String password) {
        waitForVisibilityOfElementInSeconds(getPasswordField(), 10);
        actionsHelperUtility.sendKeys(getPasswordField(), password);
    }

    public String getPasswordWarningText() {
        waitForVisibilityOfElementInSeconds(getPasswordWarning(), 10);
        return getPasswordWarning().getText();
    }

    public void clickOnSubmit() {
        waitForVisibilityOfElementInSeconds(getSubmitButton(), 10);
//        actionsHelperUtility.moveToElementAndClick(getSubmitButton());
        getSubmitButton().click();
    }

}
