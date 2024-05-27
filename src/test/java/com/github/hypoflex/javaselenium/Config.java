package com.github.hypoflex.javaselenium;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    public static final String VALID_EMAIL_ADDRESS = "test@example.com";
    public static final String INVALID_EMAIL_ADDRESS = "test@example.com";
    public static final String EXAMPLE_TEXT_1 = "This is an example";
    public static final String EXAMPLE_TEXT_2 = "Some example text";
    public static final String EXAMPLE_TEXT_3 = "The earth is flat";
    public static final String EXAMPLE_TEXT_4 = "The earth is round";
    public static final String VALID_LOGIN_MESSAGE = "successfully logged in";
    public static final String INVALID_LOGIN_MESSAGE = "enter valid credentials";
}
