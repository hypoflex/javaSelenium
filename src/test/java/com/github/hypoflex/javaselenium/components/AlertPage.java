package com.github.hypoflex.javaselenium.components;

import com.github.hypoflex.javaselenium.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Slf4j
public class AlertPage extends Page {

    private static final By defaultAlert = By.xpath("//p/a[@id='alert']");
    private static final By emptyAlert = By.xpath("//p/a[@id='empty-alert']");
    //? NOTE: We could define each alert, but instead we could also make a dynamic xpath
    //? See 'GENERIC_DIV_WITH_ID' and 'GENERIC_A_HREF_LINK_WITH_ID'
//    private static final By promptAlert = By.xpath("//p/a[@id='prompt']");
//    private static final By promptValueAlert = By.xpath("//p/a[@id='prompt-with-default']");
//    etc...

    private static final By dropdownBox = By.xpath("");
    private static final By textBox = By.xpath("");

    //? NOTE: in order to have a dynamic xpath we parse in a parameter to dynamically define the ID
    private static final String GENERIC_DIV_WITH_ID = "//div[@id='%s']";
    private static final String GENERIC_A_HREF_LINK_WITH_ID = "//p/a[@id='%s']";


    public AlertPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        log.info("Page title: {}", title);
        Assert.assertEquals(title, "Testing Alerts");
    }

    @Override
    public void isLoaded() {
        getTitle();
    }

    public AlertPage clickDefaultAlert() {
        getLocatedElement(defaultAlert).click();
        log.info("clicking element: {}", defaultAlert);
        return this;
    }

    public AlertPage clickEmptyAlert() {
        getLocatedElement(emptyAlert).click();
        log.info("clicking element: {}", emptyAlert);
        return this;
    }

    public AlertPage clickAHrefWithId(String id) {
        getLocatedElement(GENERIC_A_HREF_LINK_WITH_ID.formatted(id)).click();
        log.info("clicking element: {}", GENERIC_A_HREF_LINK_WITH_ID.formatted(id));
        return this;
    }

    public AlertPage assertAlert(String expected) {
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
        return this;
    }

    public AlertPage assertPromptAlertInputResult(String expected) {
        var promptText = getLocatedElement(GENERIC_DIV_WITH_ID.formatted("text")).getText();
        try {
            Assert.assertEquals(promptText, expected);
        } catch (AssertionError e) {
            log.error("Assertion failed: {}", e.getMessage());
        }
        return this;
    }

    public AlertPage assertPromptAlertInputResult(String divId,String expected) {
        var promptText = getLocatedElement(GENERIC_DIV_WITH_ID.formatted(divId)).getText();
        try {
            Assert.assertEquals(promptText, expected);
        } catch (AssertionError e) {
            log.error("Assertion failed: {}", e.getMessage());
        }
        return this;
    }

    public AlertPage setPromptAlertInput(String input) {
        Alert alert = getAlertIsPresent();
        alert.sendKeys(input);
        return this;
    }

    public void acceptAlert() {
        Alert alert = getAlertIsPresent();
        alert.accept();
    }

    public void dismissAlert() {
        Alert alert = getAlertIsPresent();
        alert.dismiss();
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
