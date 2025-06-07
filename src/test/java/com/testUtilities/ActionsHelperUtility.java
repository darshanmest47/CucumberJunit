package com.testUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelperUtility {
    private static ActionsHelperUtility actionHelperUtility = null;
    private static Actions actions = null;

    private ActionsHelperUtility() {
    }

    public static ActionsHelperUtility getInstance(WebDriver driver) {
        if (actionHelperUtility == null) {
            actionHelperUtility = new ActionsHelperUtility();
            actions = new Actions(driver);
        }
        return actionHelperUtility;
    }

    /*Abstraction is achieved here by exposing methods and hiding the implementation */
    /*Test classes don't know what actions are getting performed inside the methods  exposed*/

    public void moveToElementAndClick(WebElement element) {
        actions.moveToElement(element).build().perform();
    }


    public void sendKeys(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void doubleClick(WebElement element) {
        actions.doubleClick().build().perform();
    }

    public boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}
