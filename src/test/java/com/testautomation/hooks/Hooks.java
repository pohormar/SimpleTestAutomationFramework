package com.testautomation.hooks;

import com.testautomation.core.driver.DriverContext;

import com.testautomation.core.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;

public class Hooks {

    private final static Logger logger = Logger.getLogger(Hooks.class);
    private DriverContext context;

    @Autowired
    Hooks(DriverContext context) {
        this.context = context;
    }

    @Before
    public void initalizeScenario() {
        PropertyConfigurator.configure("log4j.properties");
        this.context.setDriver(DriverFactory.getWebDriver());

        logger.info("test initialized");
    }

    @After
    public void after() {
        logger.info("closing test");
        context.getDriver().quit();
    }
}
