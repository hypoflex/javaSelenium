package dev.selenium;


import dev.selenium.components.*;
import org.testng.annotations.Test;

import static dev.selenium.components.Page.*;

public class MainTest extends SetupTest {


    @Test
    public void loginPageTest() {
        LoginPage loginPage = openWebpage("login", LoginPage.class);
        loginPage.setUsername(Config.validUsername);
        loginPage.setPassword(Config.validPassword);
        loginPage.submitForm();
        threadSleep(5000);
    }
}
