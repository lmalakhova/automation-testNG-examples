package com.waverley.listeners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

/**
 * Class was implemented for testing with Listeners .
 */
public class MethodListener implements IInvokedMethodListener {
    private static final Logger LOG = Logger.getLogger(MethodListener.class.getName());

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
