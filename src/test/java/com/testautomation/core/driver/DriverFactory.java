package com.testautomation.core.driver;

import com.testautomation.core.configuration.ConfigReader;
import com.testautomation.core.driver.eventhandlers.DefaultEventHandler;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

        switch (configuration.getProperty("driver.Type")) {
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
                System.setProperty("webdriver.ie.driver", "resources/IEDriverServer.exe");
                webDriver = new InternetExplorerDriver();
                logger.info("[IE driver selected]");
                break;
            case "firefox":
            default:
                System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
                webDriver = new FirefoxDriver();
                logger.info("[Firefox driver selected]");
                break;
        }

        configureWebDriver(webDriver);
        return wrapIntoEventFiringWebdriver(webDriver);
    }

    private static void configureWebDriver(WebDriver driver) {
        int implicitWait = Integer.parseInt(configuration.getProperty("timeout.implicitlyTimeout"));
        int pageLoadTimeout = Integer.parseInt(configuration.getProperty("timeout.pageLoadTimeout"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        driver.get(configuration.getProperty("url"));
    }

    private static EventFiringWebDriver wrapIntoEventFiringWebdriver(WebDriver driver) {
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
        DefaultEventHandler handler = new DefaultEventHandler();
        eventDriver.register(handler);
        return eventDriver;
    }

}
