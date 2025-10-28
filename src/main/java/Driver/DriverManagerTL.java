package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Objects;

public class DriverManagerTL {

    public static final ThreadLocal<WebDriver> dr= new ThreadLocal<>();

    public static void setDriver(WebDriver driverref)
    {
        dr.set(driverref);
    }

    public static WebDriver getDriver()
    {
        return  dr.get();
    }

    //Unload
    public static void init()
    {
        if(Objects.isNull(DriverManagerTL.getDriver()))
        {
            WebDriver driver= new EdgeDriver();
            setDriver(driver);
        }
    }

    public static void down()
    {
        if(Objects.nonNull(DriverManagerTL.getDriver()))
        {
            getDriver().quit();

        }
    }
}
