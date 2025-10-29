package Pages.PageObjectModel;

import Base.CommonToAllPages;
import Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage_POM extends CommonToAllPages {

    WebDriver driver;

    public LoginPage_POM() {
        super();

    }


    //  Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signinbutton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");


    // Page Actions
    public String loginToVWOInvalidCreds() {
        enterInput(username, PropertyReader.readyKey("username"));
        enterInput(password, "admin");
        clickElement(signinbutton);
        presenceOfElement(error_message);
        visibilityOfElement(error_message);
        return getElement(error_message).getText();

    }


    public void loginToVWOValidCreds() {
        enterInput(username, PropertyReader.readyKey("username"));
        enterInput(password, PropertyReader.readyKey("password"));
        clickElement(signinbutton);
        // Dashboard
    }

    public DashboardPage_POM afterLoginVWOValidCreds(){
        return new DashboardPage_POM();
    }


}

