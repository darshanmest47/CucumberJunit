package POM;

import com.testUtilities.ActionsHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.testUtilities.WaitUtilities.waitForVisibilityOfElementInSeconds;

public class AmazonUserNamePage extends BasePage{
    private ActionsHelperUtility actionsHelperUtility = null;

    public AmazonUserNamePage(WebDriver driver) {
        super(driver);
        actionsHelperUtility = ActionsHelperUtility.getInstance(driver);
    }

    @FindBy(xpath = "//input[@type='email']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
    private WebElement signInText;

    private WebElement getUserNameField() {
        return userNameField;
    }

    private WebElement getSubmitButton() {
        return submitButton;
    }

    private WebElement getSignInText() {
        return signInText;
    }

    public void enterUserName(String userName) {
        waitForVisibilityOfElementInSeconds(getUserNameField(), 10);
        actionsHelperUtility.sendKeys(getUserNameField(), userName);
    }

    public void clickSubmitButton() {
        waitForVisibilityOfElementInSeconds(getSubmitButton(), 100);
//        actionsHelperUtility.moveToElementAndClick(getSubmitButton());
        getSubmitButton().click();
    }

    public String getcreateAccountText() {
        waitForVisibilityOfElementInSeconds(getSignInText(), 100);
        return getSignInText().getText().trim();
    }

}
