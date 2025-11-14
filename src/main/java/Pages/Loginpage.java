package Pages;


import Base.UsedForAllPages;
import Driver.DriverManagerTL3;
import Utils.PropertyReader3;
import org.openqa.selenium.By;

//3rd Framework
public class Loginpage extends UsedForAllPages {

    public Loginpage()
    {
        super();
    }


    //Page locators
    private By username= By.id("login-username");
    private By password= By.id("login-password");
    private By signinbutton=By.id("js-login-btn");

    By error_message=By.id("js-notification-box-msg");

    //Page Actions

    public Loginpage loginToVWO(boolean invalid) throws Exception
    {
        if (!invalid)
        {
            enterInput(username, PropertyReader3.readKey("invalid_username"));

        }else {
            enterInput(password, PropertyReader3.readKey("username"));
        }

        enterInput(password,PropertyReader3.readKey("password"));
        clickElement(signinbutton);
        return this;
    }

    public String error_message_text() throws InterruptedException
    {
        visibilityOfElementLocated(error_message);
        return DriverManagerTL3.getDriver().findElement(error_message).getText();
    }

    public DashboardPage afterlogin()
    {
        return  new DashboardPage();
    }
}
