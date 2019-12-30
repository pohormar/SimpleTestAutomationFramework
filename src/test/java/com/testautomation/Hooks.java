package com.testautomation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        plugin   = {"pretty"},
        glue     = {"com.testautomation.steps"})
public class Hooks {

    final static Logger logger = Logger.getLogger(Hooks.class);

    @Before
    public void initalizeScenario(){
        PropertyConfigurator.configure("log4j.properties");
        logger.info("test initialized");
    }
}
