package com.testautomation.core.driver;

import com.testautomation.core.configuration.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private final static Logger logger = Logger.getLogger(DriverFactory.class);
    private final static Properties configuration;

    static {
        logger.info("[Reading configuration]");
        configuration = ConfigReader.readPropertiesFile();
    }

    public static EventFiringWebDriver getWebDriver() {
        WebDriver webDriver;

        switch (configuration.getProperty("driverType")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                webDriver = new ChromeDriver();
                logger.info("[Chrome driver selected]");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "resources/MicrosoftWebDriver.exe");
                webDriver = new EdgeDriver();
                logger.info("[Edge driver selected]");
                break;
            case "ie":
            default:
                System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
                webDriver = new InternetExplorerDriver();
                logger.info("[IE driver selected]");
                break;
        }

        configureWebDriver(webDriver);
        return wrapIntoEventFiringWebdriver(webDriver);
    }

    private static void configureWebDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(configuration.getProperty("implicitlyTimeout")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(configuration.getProperty("pageLoadTimeout")), TimeUnit.SECONDS);
        driver.get(configuration.getProperty("url"));
    }

    private static EventFiringWebDriver wrapIntoEventFiringWebdriver(WebDriver driver) {
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);
        return eventDriver;
    }

}
