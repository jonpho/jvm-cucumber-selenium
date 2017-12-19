package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    private WebDriver driver;
    private Actions action;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.action = new Actions(driver);
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(how = How.ID, using = "menu-item-26")
    public static WebElement menuSolutions;

    @FindBy(how = How.ID, using = "menu-item-1868")
    public static WebElement menuSolutionsTapStrategy;

    @FindBy(how = How.ID, using = "menu-item-1869")
    public static WebElement menuSolutionsTapAutomation;

    @FindBy(how = How.ID, using = "menu-item-1870")
    public static WebElement menuSolutionsTapConsulting;

    @FindBy(how = How.ID, using = "menu-item-1871")
    public static WebElement menuSolutionsTapLakeshore;

    public WebElement getSelector(String selector) {

        switch (selector.toUpperCase()) {
            case "MENU SOLUTIONS":
                return menuSolutions;
            case "TAP STRATEGY":
                return menuSolutionsTapStrategy;
            case "TAP AUTOMATION":
                return menuSolutionsTapAutomation;
            case "TAP CONSULTING":
                return menuSolutionsTapConsulting;
            case "TAP LAKESHORE":
                return menuSolutionsTapLakeshore;
            default:
                throw new IllegalArgumentException(String.format("Could not get element by name: %s. Is it implemented?", selector));
        }
    }


    public void getURL() {
        driver.get("http://www.tapqa.com");
    }

    public void waiting(int time) {
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

    public void hoverMenuItem(WebElement menu) {
        action.moveToElement(menu).build().perform();
        waiting(2);
    }

    public void hoverSolutionsMenu() {
        hoverMenuItem(menuSolutions);
    }

    public void verifyMenuItem(String expectedMenu, WebElement menu) {
        Assert.assertEquals(menu.getText(), expectedMenu);
    }

    public void verifyTapStrategyMenu(String menuItem) {
        verifyMenuItem(menuItem, menuSolutionsTapStrategy);
    }

    public void verifySolutionsSubMenus(String menuItem, String element) {
        switch(element) {
            case "STRATEGY":
                verifyMenuItem(menuItem, menuSolutionsTapStrategy);
                break;
            case "AUTOMATION":
                verifyMenuItem(menuItem, menuSolutionsTapAutomation);
                break;
            case "CONSULTING":
                verifyMenuItem(menuItem, menuSolutionsTapConsulting);
                break;
            case "LAKESHORE":
                verifyMenuItem(menuItem, menuSolutionsTapLakeshore);
                break;
        }
    }

}
