package support;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.DriverFactory;

public class Hooks {

    private WebDriver driver;

    @Before
    public void beforeScenario() {
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().setSize(new Dimension(1600, 1050));
        driver.manage().window().maximize();
        driver.get("http://www.tapqa.com");
    }

    @After
    public void afterScenario() {
        driver.quit();
    }
}
