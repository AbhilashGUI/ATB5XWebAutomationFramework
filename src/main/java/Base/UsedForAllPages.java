package Base;

import Driver.DriverManagerTL3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UsedForAllPages {

 // 3rd framework
    protected UsedForAllPages()
    {

    }

    protected void implicitwait()
    {
        DriverManagerTL3.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    protected void enterInput(By by, String key) {
        DriverManagerTL3.getDriver().findElement(by).sendKeys(key);
    }


    protected void clickElement(By by)
    {
        DriverManagerTL3.getDriver().findElement(by).click();
    }
    protected WebElement getElement(By key)
    {
        return DriverManagerTL3.getDriver().findElement(key);
    }
    protected WebElement presenceOfElement(final By elementLocation)
    {
        return new WebDriverWait(DriverManagerTL3.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    protected WebElement visibilityOfElementLocated(final By elementLocation)
    {
        return new WebDriverWait(DriverManagerTL3.getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    protected WebElement elementtobeClickable(final By elementIdentifier)
    {
    WebElement element=new WebDriverWait(DriverManagerTL3.getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(elementIdentifier));
    return element;
    }

}
