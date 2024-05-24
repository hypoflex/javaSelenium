package dev.selenium.tests.negative;

import dev.selenium.Config;
import dev.selenium.SetupTest;
import dev.selenium.components.LoginPage;
import org.testng.annotations.Test;

import static dev.selenium.components.Page.threadSleep;

public class NegativeLoginTest extends SetupTest {

    @Test
    public void invalidUsernameTest() {
        LoginPage loginPage = openWebpage("login", LoginPage.class);
        loginPage.setUsername(Config.invalidUsername);
        loginPage.setPassword(Config.validPassword);
        loginPage.submitForm();
        loginPage.assertAlert("enter valid credentials");
    }

    @Test
    public void invalidPasswordTest() {
        LoginPage loginPage = openWebpage("login", LoginPage.class);
        loginPage.setUsername(Config.validUsername);
        loginPage.setPassword(Config.invalidPassword);
        loginPage.submitForm();
        loginPage.assertAlert("enter valid credentials");
    }

    @Test
    public void invalidCredentialsTest() {
        LoginPage loginPage = openWebpage("login", LoginPage.class);
        loginPage.setUsername(Config.invalidUsername);
        loginPage.setPassword(Config.invalidPassword);
        loginPage.submitForm();
        loginPage.assertAlert("enter valid credentials");
    }

}
