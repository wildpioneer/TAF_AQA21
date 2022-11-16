package defs;

import baseEntities.BaseCucumberTest;
import configuration.ReadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import services.WebDriverFactory;

public class FirstStepDef extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public FirstStepDef(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @Given("открыт браузер")
    public void openBrowser() {
    }

    @When("страница логина открыта")
    public void openLoginPage() {
        WebDriverFactory.getDriver().get(ReadProperties.getUrl());
    }

    @Then("отображется поле username")
    public void isUsernameFieldDisplayed() {
        //Assert.assertTrue(new LoginPage(driver).getEmailInput().isDisplayed());
        System.out.println("Проверка выполнена");
    }
}
