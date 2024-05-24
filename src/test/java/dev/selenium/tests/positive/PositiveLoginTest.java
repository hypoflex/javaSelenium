package dev.selenium.tests.positive;

import dev.selenium.Config;
import dev.selenium.SetupTest;
import dev.selenium.components.LoginPage;
import org.testng.annotations.Test;

import static dev.selenium.components.Page.threadSleep;

public class PositiveLoginTest extends SetupTest {

    @Test
    public void loginPageTest() {
        LoginPage loginPage = openWebpage("login", LoginPage.class);
        loginPage.setUsername(Config.validUsername);
        loginPage.setPassword(Config.validPassword);
        loginPage.submitForm();
        loginPage.assertAlert("successfully logged in");
    }
}
