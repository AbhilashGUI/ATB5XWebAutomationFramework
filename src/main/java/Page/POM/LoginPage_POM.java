package Page.POM;

import Base.UsedForAllPages;
import Driver.DriverManagerTL3;
import Utils.PropertyReader2;
import org.openqa.selenium.By;

public class LoginPage_POM extends UsedForAllPages {

    public LoginPage_POM()
    {
        super();
    }


    //Pagelocators

    By username= By.id("login-username");
    By password= By.id("login-password");
    By signbutton= By.id("js-login-btn");
    By error_popup=By.id("js-notification-box-msg");


    //Pageactions
    public LoginPage_POM LoginToVWOPositive() throws Exception {
        enterInput(username, PropertyReader2.readykey("username"));
        enterInput(password, PropertyReader2.readykey("password"));
        clickElement(signbutton);
        //DriverManager.getDriver().findElement(password).click();
        // Pass the control the DashboardPage
        return this;
    }

       public void openUrl(String url)
       {
           DriverManagerTL3.getDriver().get(url);
       }

       public String LoginToVWONegative() throws Exception {
           enterInput(username, "admin");
           enterInput(password,PropertyReader2.readykey("password"));
           clickElement(signbutton);
           // error String
           visibilityOfElement(error_popup);
           return getElement(error_popup).getText();

       }

    public DashboardPage_POM afterLogin(){
        return  new DashboardPage_POM();
    }

       }

