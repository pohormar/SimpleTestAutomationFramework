package com.testautomation.steps;

import com.testautomation.core.driver.DriverContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;


public class TestSteps {
    private final static Logger logger = Logger.getLogger(TestSteps.class);
    private DriverContext context;

    @Autowired
    public TestSteps(DriverContext context) {
        this.context = context;
    }

    @Given("go to wikipedia")
    public void goToGoogle() {
        context.getDriver().get("http://wikipedia.pl");
    }

    @When("click on source")
    public void clickOnSource() {
        context.getDriver().findElement(By.id("ca-viewsource")).click();
    }

    @Then("source header is displayed")
    public void sourceHeaderIsDisplayed() {
        Assert.assertTrue(context.getDriver().findElement(By.id("firstHeading")).isDisplayed());
    }
}
