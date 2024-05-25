package dev.selenium.tests.negative;

import dev.selenium.Config;
import dev.selenium.SetupTest;
import dev.selenium.components.LoginPage;
import org.testng.annotations.Test;

public class NegativeLoginTest extends SetupTest {

    LoginPage loginPage;
    public LoginPage openWebpage() {
        return openWebpage("login", LoginPage.class);
    }

    @Test
    public void invalidUsernameTest() {
        loginPage = openWebpage();
        loginPage.setUsername(Config.INVALID_USERNAME);
        loginPage.setPassword(Config.VALID_PASSWORD);
        loginPage.submitForm();
        loginPage.assertAlert("enter valid credentials");
    }

    @Test
    public void invalidPasswordTest() {
        loginPage = openWebpage();
        loginPage.setUsername(Config.VALID_USERNAME);
        loginPage.setPassword(Config.INVALID_PASSWORD);
        loginPage.submitForm();
        loginPage.assertAlert("enter valid credentials");
    }

    @Test
    public void invalidCredentialsTest() {
        loginPage = openWebpage();
        loginPage.setUsername(Config.INVALID_USERNAME);
        loginPage.setPassword(Config.INVALID_PASSWORD);
        loginPage.submitForm();
        loginPage.assertAlert("enter valid credentials");
    }

}
