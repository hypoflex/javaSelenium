package com.github.hypoflex.javaselenium;

public class Config {

    // It is not allowed to use the constructor of this class, this is a helper class.
    // The purpose of this class is pure to aid as ENUM class
    private void stringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static final String VALID_USERNAME = "username";
    public static final String VALID_PASSWORD = "password";
    public static final String INVALID_USERNAME = "invalidUsername";
    public static final String INVALID_PASSWORD = "invalidPassword";
    public static final String ALERT_DOES_NOT_CONTAIN_EXPECTED_SUBSTRING = "Alert does not contain the expected substring: '%s' but received '%s'";
}
