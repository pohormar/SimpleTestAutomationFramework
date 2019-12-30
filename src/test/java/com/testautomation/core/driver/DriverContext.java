package com.testautomation.core.driver;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.stereotype.Component;

@Component
public class DriverContext {

    private EventFiringWebDriver driver;

    public EventFiringWebDriver getDriver() {
        return driver;
    }

    public void setDriver(EventFiringWebDriver driver) {
        this.driver = driver;
    }

}
