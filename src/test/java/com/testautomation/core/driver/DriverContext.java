package com.testautomation.core.driver;

import com.testautomation.core.configuration.ConfigReader;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class DriverContext {

    private EventFiringWebDriver driver;
    private Wait wait;

    public EventFiringWebDriver getDriver() {
        return driver;
    }

    public WebDriverWait GetWebdriverWait() {
        return wait;
    }

    public void setDrivers(EventFiringWebDriver driver) {
        this.driver = driver;
        int timeout = Integer.parseInt(ConfigReader.getProperty("webDriverWaitTimeout"));
        this.wait = new Wait(driver, timeout);
    }

}
