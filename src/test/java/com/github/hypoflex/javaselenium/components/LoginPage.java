package com.github.hypoflex.javaselenium.components;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Slf4j
public class LoginPage extends Page {

    private static final By loginForm = By.xpath("//form");
    private static final By loginUsername = By.xpath("//form/input[@name='username']");
    private static final By loginPassword = By.xpath("//form/input[@name='password']");
    private static final By loginSubmit = By.xpath("//form/input[@value='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        log.info("Page title: {}", title);
        Assert.assertEquals(title, "Login");
    }

    @Override
    public void isLoaded() {
        getTitle();
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

    public void assertAlert(String expected) {
        Alert alert = getAlertIsPresent();
        threadSleep(2000); //Give user time to see the message
        try {
            Assert.assertTrue(getAlertText(alert).contains(expected));
            // Log success if the assertion passes
            log.info("Assertion passed: '{}'", expected);
        } catch (AssertionError e) {
            // Log failure and the assertion message if the assertion fails
            log.error("Assertion failed: {}", e.getMessage());
        }
        alert.accept();
    }

    private Alert getAlertIsPresent() {
        try {
            return driverWait().until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            log.error("Alert was not present: {}", e.getMessage());
            throw e;
        }
    }

    private String getAlertText(Alert alert) {
        return alert.getText();
    }
}
