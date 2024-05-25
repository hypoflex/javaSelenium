package com.github.hypoflex.javaselenium.tests.positive;

import com.github.hypoflex.javaselenium.Config;
import com.github.hypoflex.javaselenium.SetupTest;
import com.github.hypoflex.javaselenium.components.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends SetupTest {

    @Test
    public void loginPageTest() {
        LoginPage loginPage = openWebpage("login", LoginPage.class);
        loginPage.setUsername(Config.VALID_USERNAME);
        loginPage.setPassword(Config.VALID_PASSWORD);
        loginPage.submitForm();
        loginPage.assertAlert("successfully logged in");
    }
}
