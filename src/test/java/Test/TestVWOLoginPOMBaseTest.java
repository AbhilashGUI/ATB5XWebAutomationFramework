package Test;


import BaseTest.CommonToAllTest;
import Pages.PageObjectModel.LoginPage_POM;
import Utils.PropertyReader;
import org.assertj.core.api.Assertions;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginPOMBaseTest extends CommonToAllTest {

@Test(groups = {"smoke"})
public void TestLoginNegative() //1st Framework
{
    LoginPage_POM loginPagePom= new LoginPage_POM();
    loginPagePom.openVWOLoginUrl();
    String error_msg_text= loginPagePom.loginToVWOInvalidCreds();

    //TestNG
    Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");

    //AssertJ
    Assertions.assertThat(error_msg_text)
            .isNotNull()
            .isNotBlank()
            .contains(PropertyReader.readyKey("error_message"));



}
}