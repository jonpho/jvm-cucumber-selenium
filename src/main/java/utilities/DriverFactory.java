package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {


    public static WebDriver getDriver(String browser) {

        switch (browser) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
        }
        return null;
    }
}
