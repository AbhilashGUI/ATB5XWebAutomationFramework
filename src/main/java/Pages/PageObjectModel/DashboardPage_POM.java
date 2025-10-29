package Pages.PageObjectModel;

import Base.CommonToAllPages;
import org.openqa.selenium.By;

public class DashboardPage_POM extends CommonToAllPages {

    public DashboardPage_POM() {
    }

        // Page Locators
        By UserNameOnDashboard = By.cssSelector("[data-qa=\"lufexuloga\"]");


        // Page Actions
        public String loggedInUserName () {
            presenceOfElement(UserNameOnDashboard);
            return getElement(UserNameOnDashboard).getText();
        }


    }



