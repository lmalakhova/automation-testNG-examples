package com.waverley.listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Class was implemented for testing with Listeners.
 */
@SuppressWarnings("all")
public class TestListener implements ITestListener {
    public static WebDriver driver;

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    }

    @Override
    public void onTestFailure(ITestResult result) {
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        if (context.getCurrentXmlTest().getParameter("browser").equals("chrome")) {
            WebDriverManager.getInstance(ChromeDriver.class).setup();
            try {
                driver = new ChromeDriver();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        if (driver != null) {
            driver.quit();
        }
    }
}
