package com.testautomation.steps;

import com.testautomation.core.driver.DriverContext;
import com.testautomation.pages.WikipediaResultPage;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.junit.Assert;

public class WikipediaResultPageSteps {

    private final static Logger logger = Logger.getLogger(WikipediaMainPageSteps.class);
    private final WikipediaResultPage resultPage;
    private final DriverContext context;

    public WikipediaResultPageSteps(DriverContext context){
        this.context = context;
        this.resultPage = new WikipediaResultPage(context);
    }

    @Then("result page is displayed")
    public void sourceHeaderIsDisplayed() throws InterruptedException {
        Assert.assertTrue(resultPage.articleHeader.isDisplayed());
        Assert.assertTrue(resultPage.articleHeader.getText().contains("Selenium"));
        Assert.assertTrue(resultPage.articleContentText.isDisplayed());
    }
}
