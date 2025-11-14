package Page.POM;

import Base.Basepage;
import Driver.DriverManagerTL2;
import Utils.PropertyReader2;
import org.openqa.selenium.By;


//Cucumber BDD Framework
public class LoginPage_POM extends Basepage {

    public LoginPage_POM()
    {
        super();
    }


    //Pagelocators

    By username= By.id("login-username");
    By password= By.id("login-password");
    By signbutton= By.id("js-login-btn");
    By error_message=By.id("js-notification-box-msg");


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
           DriverManagerTL2.getDriver().get(url);
       }

       public String LoginToVWONegative() throws Exception {
           enterInput(username, "admin");
           enterInput(password,PropertyReader2.readykey("password"));
           clickElement(signbutton);
           // error String
           visibilityOfElement(error_message);
           return getElement(error_message).getText();

       }

    public DashboardPage_POM afterLogin(){
        return  new DashboardPage_POM();
    }

       }

