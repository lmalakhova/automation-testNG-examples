package com.waverley;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import static java.util.Optional.ofNullable;

/**
 * Class was implemented for testing with Listeners.
 */
@SuppressWarnings("all")
public class WebDriverListener implements IInvokedMethodListener {
    private static final ThreadLocal<WebDriver> DRIVER_CONTANER = new ThreadLocal<>();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            final String browser = testResult.getTestContext().getCurrentXmlTest().getParameter("browser");
            if (browser.equals("chrome")) {
                WebDriverManager.getInstance(ChromeDriver.class).setup();
                try {
                    DRIVER_CONTANER.set(new ChromeDriver());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            ofNullable(getDriver()).ifPresent(d -> d.quit());
        }
    }

    public static WebDriver getDriver() {
        return DRIVER_CONTANER.get();
    }
}
