package dev.selenium.components;

import dev.selenium.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
        var alert = getAlertIsPresent();
        threadSleep(2000); //Give time to see the message
        Assert.assertTrue(getAlertText(alert).contains(expected), Config.ALERT_DOES_NOT_CONTAIN_EXPECTED_SUBSTRING.formatted(expected, getAlertText(alert)));
        alert.accept();
    }

    private Alert getAlertIsPresent() {
        return driverWait().until(ExpectedConditions.alertIsPresent());
    }

    private String getAlertText(Alert alert) {
        return alert.getText();
    }
}
