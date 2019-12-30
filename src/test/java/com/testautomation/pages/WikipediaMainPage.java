package com.testautomation.pages;

import com.testautomation.core.driver.DriverContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaMainPage {

    private final DriverContext context;

    @FindBy(className = "mw-wiki-logo")
    public WebElement wikiLogo;

    @FindBy(css = "#simpleSearch #searchInput")
    public WebElement searchTextBox;

    @FindBy(id = "searchButton")
    public WebElement searchButton;

    public WikipediaMainPage(DriverContext context) {
        this.context = context;
        PageFactory.initElements(context.getDriver(), this);
    }

}
