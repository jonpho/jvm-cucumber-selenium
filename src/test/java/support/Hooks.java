package support;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Config;
import utilities.DriverFactory;

import static utilities.Config.BASE_URL;
import static utilities.Config.BROWSER;
import static utilities.Config.ENV;

public class Hooks {

    private WebDriver driver;

    private Config config = new Config();

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void beforeScenario() {
        config.loadProperties(ENV);
        driver = DriverFactory.getDriver(BROWSER);
        driver.manage().window().maximize();
//        If Maximize crashes the framework comment out the maximize line and use the setSize method below.
//        driver.manage().window().setSize(new Dimension(1600, 1050));

    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}
