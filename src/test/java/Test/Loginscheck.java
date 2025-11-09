package Test;

import BaseTest.UserForAllTest;
import Page.POM.DashboardPage_POM;
import Page.POM.LoginPage_POM;
import Utils.PropertyReader2;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Loginscheck extends UserForAllTest {

    @Test(priority = 1)
    public void TestLoginNegative() throws Exception {
        LoginPage_POM pagePom= new LoginPage_POM();
        pagePom.openUrl(PropertyReader2.readykey("url"));
        String error_popup=pagePom.LoginToVWONegative();
        Assertions.assertThat(error_popup)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader2.readykey(error_popup));

    }

    @Test(priority = 2)
    public void TestLoginPositive() throws Exception {
        LoginPage_POM pagePom=new LoginPage_POM();
        pagePom.openUrl(PropertyReader2.readykey("url"));
        DashboardPage_POM dashboardPagePom=pagePom.LoginToVWOPositive().afterLogin();
        String expected_username= dashboardPagePom.loggedInUserName();
        Assertions.assertThat(expected_username)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader2.readykey("expected_username"));
        }



}
