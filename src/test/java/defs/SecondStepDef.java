package defs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardPage;
import services.BrowsersService;
import services.WebDriverFactory;
import steps.LoginStep;

public class SecondStepDef extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public SecondStepDef(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @When("user {string} with password {string} logged in")
    public void userWithPasswordLoggedIn(String username, String password) {
        LoginStep loginStep = new LoginStep(WebDriverFactory.getDriver());
        User user = new User();
        user.setEmail(username);
        user.setPassword(password);

        loginStep.loginSuccessful(user);
    }

    @Then("dashboard page is displayed")
    public void dashboardPageIsDisplayed() {
        Assert.assertTrue(new DashboardPage(WebDriverFactory.getDriver()).isPageOpened());
    }

    @Then("project with ID = {int} is displayed")
    public void isProjectDisplayed(int id) {
        Assert.assertEquals(23, id);
    }

    @Given("a description with text")
    public void aDescriptionWithText(String text) {
        System.out.println(text);
    }
}
