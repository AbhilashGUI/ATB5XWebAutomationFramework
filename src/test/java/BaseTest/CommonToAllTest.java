package BaseTest;


import Driver.DriverManagerTL;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {


    @BeforeMethod(alwaysRun = true)
    public void setup()
    {
        DriverManagerTL.init();
    }


    @AfterMethod(alwaysRun = true)
    public void teardown()
    {
        DriverManagerTL.down();
    }


    public void testprint()
    {
        System.out.println("Hi, I'm basetestclass");
    }
}
