package Page.POM;

import Base.Basepage;
import org.openqa.selenium.By;

//Cucumber BDD Framework

public class DashboardPage_POM extends Basepage {

    DashboardPage_POM() {
    }

    By UserNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(UserNameOnDashboard);
        return getElement(UserNameOnDashboard).getText();

    }



}


