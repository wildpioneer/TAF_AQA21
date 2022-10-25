package utils;

import baseEntities.BaseTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult testResult) {
        try {
            ITestContext iTestContext = testResult.getTestContext();
            WebDriver driver = (WebDriver) iTestContext.getAttribute("driver");

            byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(srcFile);

        } catch (Exception ex) {

        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        try {
            WebDriver driver = (WebDriver) iTestContext.getAttribute("driver");

            byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            saveScreenshot(srcFile);

        } catch (Exception ex) {

        }
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }

    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }
}
