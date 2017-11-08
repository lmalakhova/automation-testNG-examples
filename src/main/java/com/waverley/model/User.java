package com.waverley.model;

/**
 * Class was implemented for @DataSupplier testing.
 */
public class User {
    private final String firstName;
    private final String password;

    public User(final String firstName, final String password) {
        this.firstName = firstName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{"
                + "firstName='" + firstName + '\''
                + ", password='" + password + '\''
                + '}';
    }
}


