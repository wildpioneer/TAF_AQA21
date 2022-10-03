package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleDriver {

    public WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/aleksandr/Documents/Work/TechMeSkills/code/TAF_AQA21/TAF_AQA21/src/test/resources/chromedriver");

        return new ChromeDriver();
    }
}
