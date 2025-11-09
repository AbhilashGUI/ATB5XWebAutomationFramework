package BaseTest;

import Driver.DriverManagerTL3;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class UserForAllTest {

    // To call the Start the Webdriver
    // Down the WebDriver

    // Who will start the Webdriver?
    @BeforeMethod
    protected void setUp() throws MalformedURLException {
        DriverManagerTL3.init();
    }

    // Who will close the Webdriver
    @AfterMethod
    protected void tearDown(){
        DriverManagerTL3.down();
    }
}
