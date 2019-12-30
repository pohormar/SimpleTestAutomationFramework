package com.testautomation.steps;

import com.testautomation.core.driver.DriverContext;
import com.testautomation.core.driver.DriverFactory;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class TestSteps {
    final static Logger logger = Logger.getLogger(TestSteps.class);
    private DriverContext context;

    @Autowired
    public TestSteps(DriverContext context){
        this.context = context;
    }

    @Given("go to google")
    public void examplestep(){
        context.setDriver(DriverFactory.getWebDriver());
        context.getDriver().get("http://google.pl");
    }
}
