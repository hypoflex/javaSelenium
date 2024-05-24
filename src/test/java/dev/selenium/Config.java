package dev.selenium;

public class Config {

    // It is not allowed to use the constructor of this class, this is a helper class.
    // The purpose of this class is pure to aid as ENUM class
    private void stringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static final String validUsername = "username";
    public static final String validPassword = "password";
    public static final String invalidUsername = "invalidUsername";
    public static final String invalidPassword = "invalidPassword";
}
