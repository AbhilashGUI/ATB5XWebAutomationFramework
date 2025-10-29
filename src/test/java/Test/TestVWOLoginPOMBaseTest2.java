package Test;

import BaseTest.CommonToAllTest;
import Pages.PageObjectModel.DashboardPage_POM;
import Pages.PageObjectModel.LoginPage_POM;
import Utils.PropertyReader;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginPOMBaseTest2 extends CommonToAllTest {


    @Test
    public void Testloginpositive()
    {

       LoginPage_POM loginPagePom = new LoginPage_POM();
       loginPagePom.openVWOLoginUrl();
        loginPagePom.loginToVWOValidCreds();
       DashboardPage_POM dashboardPagePom = loginPagePom.afterLoginVWOValidCreds();
       String expected_username = dashboardPagePom.loggedInUserName();

        // TestNG
        Assert.assertEquals(expected_username, PropertyReader.readyKey("expected_username"));

        // AssertJ
        Assertions.assertThat(expected_username)
               .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readyKey("expected_username"));
    }
}
