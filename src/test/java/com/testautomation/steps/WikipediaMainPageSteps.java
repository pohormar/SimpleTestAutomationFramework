package com.testautomation.steps;

import com.testautomation.core.driver.DriverContext;
import com.testautomation.pages.WikipediaMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


public class WikipediaMainPageSteps {

    private final static Logger logger = Logger.getLogger(WikipediaMainPageSteps.class);
    private DriverContext context;
    private WikipediaMainPage wikiMainPage;

    @Autowired
    public WikipediaMainPageSteps(DriverContext context) {
        this.context = context;
        this.wikiMainPage = new WikipediaMainPage(context);
    }

    @Given("user is on main wiki page")
    public void goToWikipediaPage() {
        wikiMainPage.wikiLogo.click();
    }

    @When("user search for (.*)")
    public void clickOnSource(String searchText) throws InterruptedException {
       wikiMainPage.searchTextBox.sendKeys("selenium");
       wikiMainPage.searchButton.click();
    }

}
