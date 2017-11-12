package com.waverley;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

/**
 * Base class was implemented for Test processing.
 */
public abstract class BaseTest {
    public static final Logger LOG = Logger.getLogger(BaseTest.class.getName());

    @AfterClass
    public void methodAfterClass() {
        LOG.info("This methodAfterClass");
    }

    @BeforeClass
    public void methodBeforeClass() {
        LOG.info("This is methodBeforeClass");
    }
}
