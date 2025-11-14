package BaseTest;

import Driver.DriverManagerTL2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


//Cucumber BDD Framework
public class TestBase {

    @BeforeMethod
    protected void setup()
    {
        DriverManagerTL2.init();

    }

    @AfterMethod
    protected void teardown()
    {
        DriverManagerTL2.down();
    }

}
