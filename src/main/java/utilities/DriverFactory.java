package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

//    Make sure your Chrome Version matches your ChromeDriver exe version in the Browsers Folder

    /**
     * This method set the driver property and sets the path where the binary is located. Then sends the driver type to before Hook.
     * @param browser The browser type is currently set in the config file constant variable BROWSER.
     * @return Returns driver type back to the before hook for setup. Currently it will be either chrome or firefox.
     */
    public static WebDriver getDriver(String browser) {
        /* TODO: Expand this to support Edge */
        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", getBrowserPath(browser));
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", getBrowserPath(browser));
                return new FirefoxDriver();
        }
        return null;
    }

    /**
     * This method gets the binary location and sends to the getDriver to properly set the setProperty method.
     * @param browser The browser type will either be chrome or firefox for now until we expand to browsers
     * @return Returns the path for where the binaries are located in the untilites/browser folder.
     */
    private static String getBrowserPath(String browser) {
        String currentOS = System.getProperty("os.name").toLowerCase();
        String posixPath = "./src/main/java/utilities/browsers/";
        String setPath = "";
        /* TODO: This method needs ot be expand to edge once it has been added to the getDriver method */
        if (currentOS.contains("mac")) {
            switch (browser) {
                case "chrome":
                    setPath = posixPath + "chromedriver";
                    break;
                case "firefox":
                    setPath = posixPath + "geckodriver";
                    break;
            }
            /* TODO: Need to test this half of the method to see if it works properly on a windows machine */
        } else if (currentOS.contains("windows")) {
            switch (browser) {
                case "chrome":
                    setPath = posixPath + "chromedriver.exe";
                    break;
                case "firefox":
                    setPath = posixPath + "geckodriver.exe";
                    break;
            }
        } else {
            System.out.println("unable to find OS Type");
        }
        return setPath;
    }
}
