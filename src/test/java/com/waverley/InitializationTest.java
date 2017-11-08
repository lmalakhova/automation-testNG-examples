package com.waverley;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Class was implemented for Test processing.
 */
public class InitializationTest extends BaseTest {
    @BeforeMethod
    public void methodTwo() {
        LOG.info("This is Before methodTwo");
    }

    @Test
    public void methodTwoTest() {
        LOG.info("This is methodTwo");
    }
}

