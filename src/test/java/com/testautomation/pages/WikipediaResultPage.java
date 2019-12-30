package com.testautomation.pages;

import com.testautomation.core.driver.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaResultPage {

    private final DriverContext context;

    @FindBy(id = "firstHeading")
    public WebElement articleHeader;

    @FindBy(id = "mw-content-text")
    public WebElement articleContentText;

    public WikipediaResultPage(DriverContext context) {
        this.context = context;
        PageFactory.initElements(context.getDriver(), this);
    }

}
