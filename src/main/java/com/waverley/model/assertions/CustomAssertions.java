package com.waverley.model.assertions;

import com.waverley.model.User;
import lombok.experimental.UtilityClass;

/**
 * Utility Class for User Custom Assertions.
 */
@UtilityClass
public class CustomAssertions {
    public static UserAssert assertThat(final User user) {
        return new UserAssert(user);
    }
}
