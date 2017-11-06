package com.waverley;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthorizationTest extends com.waverley.BaseTest {
    @BeforeMethod
    public void methodBeforeOne() {
        System.out.println("This is method before methodOne");
    }

    @Test
    public void methodOneTest() {
        System.out.println("This is methodOne");
    }

    @AfterMethod
    public void methodAfterOne() {
        System.out.println("This is method after methodOne");
    }
}
