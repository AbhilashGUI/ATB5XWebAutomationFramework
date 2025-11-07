package Pages;

import Base.Basepage;
import org.openqa.selenium.By;

public class DashboardPage extends Basepage {

    DashboardPage() {

    }

    By UserNameOnDashboard = By.xpath("//span[@data-qa=\"lufexuloga\"]");

    //Page Actions
    public String loggedInUserName() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //presenceOfElement(UserNameOnDashboard);
        return getElement(UserNameOnDashboard).getText();
    }

}

