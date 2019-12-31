package com.testautomation.core.driver.waiters;

import com.testautomation.core.configuration.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class DefaultWait extends WebDriverWait {

    private WebDriver webDriver;
    private int implicitTimeout;

    public DefaultWait(WebDriver driver) {
        super(driver, ConfigReader.getPropertyAsInt("timeout.explicitWait"));

        this.webDriver = webDriver;
        this.implicitTimeout = ConfigReader.getPropertyAsInt("timeout.implicitTimeout");
    }

    public DefaultWait(WebDriver driver, int explicitTimeout) {
        super(driver, explicitTimeout);

        this.implicitTimeout = ConfigReader.getPropertyAsInt("timeout.implicitTimeout");
    }

    //todo: add lambda call instead of repeating code
    public WebElement waitForPresence(By by) {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement el = until(ExpectedConditions.presenceOfElementLocated(by));
        webDriver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        return el;
    }

    public boolean waitForInvisibility(WebElement element) {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isVisible = until(ExpectedConditions.invisibilityOf(element));
        webDriver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        return isVisible;
    }

    public WebElement waitForVisibility(By by) {
        WebElement element = null;
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement el = until(ExpectedConditions.visibilityOfElementLocated(by));
        webDriver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        return el;
    }

    public WebElement waitForVisibility(WebElement element) {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement el = until(ExpectedConditions.visibilityOf(element));
        webDriver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        return el;
    }

    public WebElement waitForElementToBeClickable(WebElement element) {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebElement el = until(ExpectedConditions.elementToBeClickable(element));
        webDriver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        return el;
    }

    public boolean waitForUrlContains(String url) {
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        boolean isContain = until(ExpectedConditions.urlContains(url));
        webDriver.manage().timeouts().implicitlyWait(implicitTimeout, TimeUnit.SECONDS);
        return isContain;
    }
}
