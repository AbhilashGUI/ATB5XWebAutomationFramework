package BaseTest;


import Driver.DriverManagerTL3;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;


//3rd Framework
public class UserForAllTest {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/report.html");
    ExtentTest test;


    //Call to Driver, Takescreenshot
    @BeforeSuite
    protected void setup() throws Exception
    {
        extent.attachReporter(spark);
        DriverManagerTL3.init();
    }
    public ExtentTest createTest(String name) {
        return extent.createTest(name).assignCategory("Regression Test").assignDevice("WindowsOS");
    }

    @BeforeTest
    public void setconfig()
    {
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("VWO Testcases");
    }

    @AfterSuite
    protected void teardown()
    {
        DriverManagerTL3.down();
        extent.flush();
    }

    protected void takeScreenShot(String name, WebDriver driver) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public static String captureScreenshot(WebDriver driver) throws IOException {
        File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination_filepath = new File(System.getProperty("user.dir") + "/images/screenshot" + System.currentTimeMillis() + ".png");
        FileUtils.copyFile(srcfile, destination_filepath);
        return destination_filepath.toString();
    }

}


