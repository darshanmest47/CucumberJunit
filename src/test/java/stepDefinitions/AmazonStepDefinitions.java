package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

import static com.testUtilities.WaitUtilities.*;

public class AmazonStepDefinitions extends BaseStep {

    public AmazonStepDefinitions() throws Exception {
    }

    @Given("I have already opened amazon")
    public void I_have_already_opened_amazon() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I am  already on amazon page");
        pageObjects.getAmazonBasePage().clickAccountList();  
        pageObjects.getAmazonBasePage().clickSignInButton();
        logger.info("Amazon webpage is opened");
    }

    @When("I enter username {string}")
    public void I_enter_username(String sheetName) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I enter username: " + sheetName);
        Map<String, String> excelData = excelReader.getRowDataBySheet(sheetName);
        pageObjects.getAmazonUserNamePage().enterUserName(excelData.get("UserName"));
        logger.info("Username is entered");
    }

    @And("I enter password {string}")
    public void I_enter_password(String sheetName) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I enter password: " + sheetName);
        Map<String, String> excelData = excelReader.getRowDataBySheet(sheetName);
        pageObjects.getAmazonPasswordPage().enterPassword(excelData.get("Password"));
        logger.info("Password is entered");
    }

    @And("I click on continue button")
    public void I_click_on_continue_button() throws Throwable {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I click on continue button");
        waitForSeconds(2000);
        pageObjects.getAmazonUserNamePage().clickSubmitButton();
        logger.info("Continue button is clicked");
    }

    @And("I click on submit button")
    public void I_click_on_submit_button() throws Throwable {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I click on submit button");
        waitForSeconds(2000);
        pageObjects.getAmazonPasswordPage().clickOnSubmit();
        logger.info("Submit button is clicked");
    }

    @When("I am on amazon homepage")
    public void I_am_on_amazon_homepage() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I am on amazon homepage");
        Assert.assertTrue(pageObjects.getAmazonHomePage().isHelloTextDisplayed());
        System.out.println("Thread: " + Thread.currentThread().getName() + " - Amazon home page is displayed");
        logger.info("Username is on amazon homepage");
    }

    @And("I click on cart icon")
    public void I_click_on_cart_icon() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I click on cart icon");
        if (pageObjects.getAmazonHomePage().isCartContainerDisplayed()) {
            pageObjects.getAmazonHomePage().clickOnCartIcon();
            logger.info("Cart icon is clicked");
        } else {
            throw new RuntimeException("Cart container is not displayed");
        }
    }

    @Then("I should be navigated to cart page {string}")
    public void I_should_be_navigated_to_cart_page(String sheetName) {
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I should be navigated to cart page: " + sheetName);
        Map<String, String> excelData = excelReader.getRowDataBySheet(sheetName);
        waitForPageLoad(excelData.get("Carturl"), 50);
        Assert.assertTrue(driver.getCurrentUrl().contains(excelData.get("Carturl")));
        System.out.println("Thread: " + Thread.currentThread().getName() + " - I have successfully landed on cart page");
        logger.info("Username is navigated to cart page");
    }
}