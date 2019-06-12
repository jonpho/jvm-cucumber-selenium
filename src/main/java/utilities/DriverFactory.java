package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

//    Make sure your Chrome Version matches your ChromeDriver exe version in the Browsers Folder

    public static WebDriver getDriver(String browser) {
        //TODO: Expand this to support Edge and Possibly Safari
        switch (browser) {
            case "chrome":
                //TODO: Update this and expand to it's own method so it pulls path for both windows path and POSIX
                System.setProperty("webdriver.chrome.driver", "./src/main/java/utilities/browsers/chromedriver");
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
        }
        return null;
    }
}
