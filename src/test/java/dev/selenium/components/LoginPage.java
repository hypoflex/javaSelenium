package dev.selenium.components;

import org.openqa.selenium.*;
import org.testng.Assert;

public class LoginPage extends Page {

    public static final By loginForm = By.xpath("//form");
    public static final By loginUsername = By.xpath("//form/input[@name='username']");
    public static final By loginPassword = By.xpath("//form/input[@name='password']");
    public static final By loginSubmit = By.xpath("//form/input[@value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("Login", title);
    }

    @Override
    public void isLoaded() {
        getLocatedElement(loginForm);
    }

    public void setUsername(String username) {
        getLocatedElement(loginUsername).sendKeys(username);
    }

    public void setPassword(String password) {
        getLocatedElement(loginPassword).sendKeys(password);
    }

    public void submitForm() {
        getLocatedElement(loginSubmit).click();
    }
}
