package Pages;

import Base.CommonToAllPage;
import Pages.PageObjectModel.DashboardPage_POM;
import Utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAllPage {
    WebDriver driver;

    public LoginPage_PF(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }

    //Page Locators

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signinbutton;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    //Page Actions
    public String logintoVWOInvalidcred() {
        enterInput(username, PropertyReader.readyKey("username"));
        enterInput(password, "admin");
        clickElement(signinbutton);
//        presenceOfElement(error_message);
//        visibilityOfElement(error_message);
        return getElement(null).getText();

    }

    public void loginToVWOValidCreds() {
        enterInput(username, PropertyReader.readyKey("username"));
        enterInput(password, PropertyReader.readyKey("password"));
        clickElement(signinbutton);
        // Dashboard
    }

    public DashboardPage_POM afterLoginVWOValidCreds() {
        return new DashboardPage_POM();
    }
}