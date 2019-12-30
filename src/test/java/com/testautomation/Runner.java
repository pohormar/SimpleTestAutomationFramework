package com.testautomation;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/"},
        plugin   = {"pretty"},
        glue     = {"com.testautomation.steps", "com.testautomation.hooks"})
public class Runner {
}
