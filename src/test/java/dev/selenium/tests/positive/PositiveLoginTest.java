package dev.selenium.tests.positive;

import dev.selenium.Config;
import dev.selenium.SetupTest;
import dev.selenium.components.LoginPage;
import org.testng.annotations.Test;

public class PositiveLoginTest extends SetupTest {

    @Test
    public void loginPageTest() {
        LoginPage loginPage = openWebpage("login", LoginPage.class);
        loginPage.setUsername(Config.VALID_USERNAME);
        loginPage.setPassword(Config.VALID_PASSWORD);
        loginPage.submitForm();
        loginPage.assertAlert("successfully logged in");
    }
}
