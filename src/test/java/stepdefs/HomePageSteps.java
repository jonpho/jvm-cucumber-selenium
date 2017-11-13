package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import support.Hooks;

public class HomePageSteps {

    private WebDriver driver;
    private HomePage page;

    public HomePageSteps(Hooks hooks) {
        this.page = new HomePage(hooks.getDriver());
        this.driver = hooks.getDriver();
    }

    @Given("^I am navigating to tapQA HomePage$")
    public void iAmNavigatingToTapQAHomePage() throws Throwable {
        page.getURL();
    }

    @When("^I hover over the Solutions tab$")
    public void iHoverOverTheSolutionsTab() throws Throwable {
        page.hoverSolutionsMenu();
    }

    @Then("^I verify that the \"([^\"]*)\" menu is displayed$")
    public void iVerifyThatTheMenuIsDisplayed(String arg0) throws Throwable {
        page.verifyTapStrategyMenu(arg0);
    }

    @Then("^I verify that \"([^\"]*)\" menu is displayed at \"([^\"]*)\" webElement$")
    public void iVerifyThatMenuIsDisplayedAtWebElement(String arg0, String arg1) throws Throwable {
        page.verifySolutionsSubMenus(arg0, arg1);
    }
}
