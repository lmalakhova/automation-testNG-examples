package com.waverley.assertions;

import com.waverley.User;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * UserAssert class was implemented for creation custom assertions methods.
 */
public class UserAssert extends AbstractAssert<UserAssert, User> {
    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of:\n<%s>\nto be:<%s>\n but was:\n<%s>";

    public UserAssert(final User user) {
        super(user, UserAssert.class);
    }

    public UserAssert hasUsername(final String firstName) {
        isNotNull();
        if (!Objects.areEqual(actual.getFirstName(), firstName)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "[Username]", actual, firstName, actual.getFirstName());
        }
        return this;
    }

    public UserAssert hasUserpassword(final String password) {
        isNotNull();
        if (!Objects.areEqual(actual.getPassword(), password)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "[Password]", actual, password, actual.getPassword());
        }
        return this;
    }
}
