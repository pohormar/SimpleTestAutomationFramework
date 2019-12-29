package Core.Driver;

import Core.Configuration.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.IOException;

public class DriverFactory {

    final static Logger logger = Logger.getLogger(DriverFactory.class);

    public static EventFiringWebDriver getWebDriver() {
        WebDriver webDriver;
        String driverType = null;

        try {
            driverType = ConfigReader.getProperty("driverType");
        } catch (IOException e) {
            logger.error("Driver type not found! Exception: " + e.getStackTrace());
        }

        switch (driverType) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "Resources/chromedriver.exe");
                webDriver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "Resources/MicrosoftWebDriver.exe");
                webDriver = new EdgeDriver();
                break;
            case "ie":
            default:
                System.setProperty("webdriver.ie.driver", "Resources/IEDriverServer.exe");
                webDriver = new InternetExplorerDriver();
                break;
        }

        EventFiringWebDriver eventDriver = new EventFiringWebDriver(webDriver);
        EventHandler handler = new EventHandler();
        eventDriver.register(handler);
        return eventDriver;
    }

}
