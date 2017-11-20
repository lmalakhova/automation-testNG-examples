package com.waverley.assertions;

import com.waverley.User;

/**
 * Utility Class for User Custom Assertions.
 */
public final class CustomAssertions {
    private CustomAssertions() {
        throw new UnsupportedOperationException();
    }

    public static UserAssert assertThat(final User user) {
        return new UserAssert(user);
    }
}
