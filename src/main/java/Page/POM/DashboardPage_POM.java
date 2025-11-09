package Page.POM;

import Base.UsedForAllPages;
import org.openqa.selenium.By;

public class DashboardPage_POM extends UsedForAllPages {

    DashboardPage_POM() {
    }

    By UserNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");

    // Page Actions
    public String loggedInUserName() {
        presenceOfElement(UserNameOnDashboard);
        return getElement(UserNameOnDashboard).getText();

    }



}


