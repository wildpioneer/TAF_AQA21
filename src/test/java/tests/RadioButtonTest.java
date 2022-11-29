package tests;

import baseEntities.BaseTest;
import configuration.ReadProperties;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class RadioButtonTest extends BaseTest {

    @Test
    public void selectByValueTest() {
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        driver.get("https://czechauanton01.testrail.io/index.php?/admin/users/add");

        RadioButton radioButton = new RadioButton(driver, By.name("invite"));
        radioButton.selectByValue("0");
    }

    @Test
    public void selectByValueTest1() {
        loginStep.login(ReadProperties.username(), ReadProperties.password());
        driver.get("https://czechauanton01.testrail.io/index.php?/admin/projects/add");

        RadioButton radioButton = new RadioButton(driver, By.name("suite_mode"));
        radioButton.selectByValue("2");
        radioButton.selectByText("Use multiple test suites to manage cases");
    }
}
