package com.waverley;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    @AfterClass
    public void methodAfterClass() {
        System.out.println("This methodAfterClass");
    }

    @BeforeClass
    public void methodBeforeClass() {
        System.out.println("This is methodBeforeClass");
    }
}
