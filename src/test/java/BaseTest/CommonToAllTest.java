package BaseTest;



import Driver.DriverManagerTL;
import Driver.DriverManagerTL2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class CommonToAllTest {   //1st Framework

  //Starts the webdriver
    @BeforeMethod(alwaysRun = true)
    public void setup() throws MalformedURLException {
        DriverManagerTL.init();
    }

    //Closes the webdriver
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
