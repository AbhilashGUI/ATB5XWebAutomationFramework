package Pages;

import Base.Basepage;
import Driver.DriverManagerTL2;
import Utils.PropertyReader;
import org.openqa.selenium.By;

public class Loginpage extends Basepage {

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
            enterInput(username, PropertyReader.readyKey("invalid_username"));

        }else {
            enterInput(password, PropertyReader.readyKey("username"));
        }

        enterInput(password,PropertyReader.readyKey("password"));
        clickElement(signinbutton);
        return this;
    }

    public String error_message_text() throws InterruptedException
    {
        visibilityOfElementLocated(error_message);
        return DriverManagerTL2.getDriver().findElement(error_message).getText();
    }

    public DashboardPage afterlogin()
    {
        return  new DashboardPage();
    }
}
