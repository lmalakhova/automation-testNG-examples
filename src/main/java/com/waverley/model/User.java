package com.waverley.model;

import lombok.Data;

/**
 * Class was implemented for @DataSupplier testing.
 */
@Data
public class User {
    private final String firstName;
    private final String password;

    public static User dummy() {
        return new User("Dummy", "dummy");
    }
}
