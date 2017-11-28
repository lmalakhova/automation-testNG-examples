package com.waverley;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Class was implemented for Test processing.
 */
public class InitializationTest extends BaseTest {
    @BeforeMethod
    public void checkTestStatus(Method method) {
        int openTestquantity = 0;
        int closeTestquantity = 0;
        final String result = java.util.Optional.of(method.getDeclaredAnnotation(TestStatus.class)
                .testStatus()).orElse("not found");
        if ("open".equals(result)) {
            openTestquantity++;
        } else {
            closeTestquantity++;
        }
        System.out.println(openTestquantity + closeTestquantity);
    }

    @TestStatus
    @Test
    public void methodTwoTest() {
        LOG.info("This is methodTwo");
    }
}
