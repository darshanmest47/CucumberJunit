package POM;

import com.testUtilities.ActionsHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.testUtilities.WaitUtilities.waitForVisibilityOfElementInSeconds;

public class AmazonHomePage  extends BasePage {
    private ActionsHelperUtility actionsHelperUtility = null;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        actionsHelperUtility = ActionsHelperUtility.getInstance(driver);
    }

    @FindBy(xpath="//span[contains(text(),'Hello, Darshan')]")
    private WebElement helloText;

    @FindBy(id="nav-cart-count-container")
    private WebElement cartContainer;

    private WebElement getCartContainer(){
        return cartContainer;
    }

    private WebElement getHelloText(){
        return helloText;
    }

    public boolean isHelloTextDisplayed(){
        try{
            waitForVisibilityOfElementInSeconds(getHelloText(), 30);
            return getHelloText().isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public boolean  isCartContainerDisplayed(){
        try{
            waitForVisibilityOfElementInSeconds(getCartContainer(),30);
            return getCartContainer().isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void clickOnCartIcon(){
        waitForVisibilityOfElementInSeconds(getCartContainer(),30);
        getCartContainer().click();
    }
}
