package Base;


import Driver.DriverManagerTL2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

//Cucumber BDD Framework

public class Basepage {

    public Basepage()
    {
        // If you want to call something before every Page Object Class call, Put your Code here");
        // Open File, Open Data Base Connection You can write code here
    }

    //waits
    public void implicitWait()
    {
        DriverManagerTL2.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    protected void enterInput(By by, String key)
    {
        DriverManagerTL2.getDriver().findElement(by).sendKeys(key);
    }


    public void clickElement(By by)
    {
        DriverManagerTL2.getDriver().findElement(by).click();
    }

    public WebElement getElement(By key)
    {
        return DriverManagerTL2.getDriver().findElement(key);
    }
    public WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(DriverManagerTL2.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(final By elementLocation) {
        return new WebDriverWait(DriverManagerTL2.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public void iWaitForElementToBeVisible(WebElement loc,String url) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManagerTL2.getDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfAllElements(loc));
            wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            System.out.println("Failed to Wait!: " + e.toString());
        }
    }
    }

