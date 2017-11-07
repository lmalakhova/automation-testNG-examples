package com.waverley;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InitializationTest extends BaseTest {
    @BeforeMethod
    public void methodTwo() {
        System.out.println("This is Before methodTwo");
    }

    @Test
    public void methodTwoTest() {
        System.out.println("This is methodTwo");
    }
}

