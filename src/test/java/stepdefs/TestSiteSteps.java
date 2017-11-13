package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import support.Hooks;

public class TestSiteSteps {

    private WebDriver driver;
    private HomePage page;

    public TestSiteSteps(Hooks hooks) {
        this.page = new HomePage(hooks.getDriver());
        this.driver = hooks.getDriver();
    }

    @Given("^I am navigating to tapQA HomePage$")
    public void iAmNavigatingToTapQAHomePage() throws Throwable {
      page.getURL();
    }

    @When("^I enter my websites name$")
    public void iEnterMyWebsitesName() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
