package POM;

import org.openqa.selenium.WebDriver;

public class PageObjects {
    AmazonBasePage amazonBasePage = null;
    AmazonUserNamePage amazonUserNamePage = null;
    AmazonPasswordPage amazonPassWordPage = null;
    AmazonHomePage amazonHomePage = null;
    WebDriver tlDriver = null;

    public PageObjects(WebDriver tlDriver) {
        this.tlDriver = tlDriver;
    }

    public AmazonBasePage getAmazonBasePage() {
        amazonBasePage = new AmazonBasePage(this.tlDriver);
        return amazonBasePage;
    }

    public AmazonUserNamePage getAmazonUserNamePage() {
        amazonUserNamePage = new AmazonUserNamePage(this.tlDriver);
        return amazonUserNamePage;
    }

    public AmazonPasswordPage getAmazonPasswordPage() {
        amazonPassWordPage = new AmazonPasswordPage(this.tlDriver);
        return amazonPassWordPage;
    }

    public AmazonHomePage getAmazonHomePage() {
        amazonHomePage = new AmazonHomePage(this.tlDriver);
        return amazonHomePage;
    }

}
