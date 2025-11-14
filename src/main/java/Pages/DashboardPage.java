package Pages;


import Base.UsedForAllPages;
import org.openqa.selenium.By;

//3rd Framework
public class DashboardPage extends UsedForAllPages {

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
        presenceOfElement(UserNameOnDashboard);
        return getElement(UserNameOnDashboard).getText();
    }

}

