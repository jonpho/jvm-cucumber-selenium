package support;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class Hooks {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @Before
    public void beforeScenario() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().setSize(new Dimension(1600, 1050));
        driver.manage().window().maximize();
    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}
