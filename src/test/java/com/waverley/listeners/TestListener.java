package com.waverley.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

/**
 * Class was implemented for Listener testing.
 */
public class TestListener implements IInvokedMethodListener {
    private static final Logger LOG = Logger.getLogger(TestListener.class.getName());

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        // not implemented
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod() && testResult.getStatus() == ITestResult.FAILURE) {
            takeScreenshot();
        }
    }

    private void takeScreenshot() {
        LOG.info("Take screenshot");
    }
}
