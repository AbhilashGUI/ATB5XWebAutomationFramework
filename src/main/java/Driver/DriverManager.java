package Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class DriverManager {  //1st Framework

public static WebDriver driver;

public static WebDriver getDriver()
{
    return driver;
}

public static void init()
{
    if(driver==null)
    {
        EdgeOptions edgeoptions= new EdgeOptions();
        edgeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeoptions.addArguments("--StartMaximized--");
        edgeoptions.addArguments("--guest--");
        //edgeoptions.addArguments("--headless--");
        driver= new EdgeDriver(edgeoptions);
    }
}

public static void down()
{
    if(driver !=null)
    {
        driver.quit();
        driver=null;
    }
}
}
