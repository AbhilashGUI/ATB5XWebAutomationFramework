package Base;

import Utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static Driver.DriverManagerTL.getDriver;


public class CommonToAllPages {   //1st Framework

    public CommonToAllPages() {
        // If you want to call something before every Page Object Class call, Put your Code here";
        // Open File, Open Data Base Connection You can write code here
    }

    public void openVWOLoginUrl() {
        getDriver().get(PropertyReader.readyKey("url"));

    }

    //This is common to all the pages, it contains some selenium helper methods
    public void clickElement(By by) {
        getDriver().findElement(by).click();
    }

    //Overloaded methods
    public void enterInput(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    public void enterInput(WebElement element, String key) {
        element.sendKeys(key);
    }

    //Wait explicits here
    public WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));

    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }
}