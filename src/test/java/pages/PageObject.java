package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class PageObject {

    private WebDriver driver;

    private String url;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Wait Methods
     */

    public void waitForElementToBeVisible(WebElement element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(100));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            /* Do Nothing */
        }
    }

    public void waitForElementToBeVisisble(By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(100));
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
        } catch (Exception e) {
            /* Do Nothing */
        }
    }

    public void waitForPresenceOfElement(By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(100));
        try {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        } catch (Exception e) {
            /* Do Nothing*/
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(100));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            /* Do Nothing */
        }
    }

    public void waitForElementToBeClickable(By element) {
        FluentWait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(120))
                .pollingEvery(Duration.ofMillis(100));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            /* Do Nothing */
        }
    }

    /**
     * DropDown Select Methods. These methods take a web element and value parameters.
     */

    public void selectDropDownByVisibleText(WebElement element, String visibleText) {
        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(visibleText);
    }

    public void selectDropDownByValue(WebElement element, String value) {
        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

}
