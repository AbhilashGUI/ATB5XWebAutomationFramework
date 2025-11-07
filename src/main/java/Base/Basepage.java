package Base;


import Driver.DriverManagerTL2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Basepage {

    protected Basepage()
    {

    }

    protected void implicitwait()
    {
        DriverManagerTL2.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void enterInput(By by, String key)
    {
        DriverManagerTL2.getDriver().findElement(by).sendKeys(key);
    }

    //Polymorphism -overloaded
    protected  void enterInput(WebElement e,String key)
    {
        e.sendKeys(key);
    }

    protected void clickElement(By by)
    {
        DriverManagerTL2.getDriver().findElement(by).click();
    }

    protected WebElement getElement(By key)
    {
        return DriverManagerTL2.getDriver().findElement(key);
    }
    protected WebElement presenceOfElement(final By elementLocation) {
        return new WebDriverWait(DriverManagerTL2.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    protected WebElement visibilityOfElementLocated(final By elementLocation) {
        return new WebDriverWait(DriverManagerTL2.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected WebElement elementToBeClickable(final By elementIdentier) {
        WebElement element = new WebDriverWait(DriverManagerTL2.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementIdentier));
        return element;
    }



}
