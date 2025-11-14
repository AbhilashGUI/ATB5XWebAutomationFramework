package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

//3rd Framework
public class DriverManagerTL3 {

    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    //Unload
    public static void unload() {
        dr.remove();
    }


    public static void down() {
        if (Objects.nonNull(DriverManagerTL3.getDriver())) {
            getDriver().quit();
            unload();
        }
    }
        public static void init()
        {
            if(Objects.isNull(DriverManagerTL3.getDriver()))
            {
                EdgeOptions options= new EdgeOptions();
                options.addArguments("--guests");
                options.addArguments("--remote-allow-origins=*");
                WebDriver driver= new EdgeDriver(options);
                setDriver(driver);
            }
        }

    }

