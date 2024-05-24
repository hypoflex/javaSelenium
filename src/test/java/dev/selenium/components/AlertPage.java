package dev.selenium.components;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AlertPage extends Page {

    public static final By defaultAlert = By.xpath("//p/a[@id='alert']");
    public static final By emptyAlert = By.xpath("//p/a[@id='empty-alert']");
    // NOTE: We could define each prompt, but instead we could also make a dynamic xpath
    // See 'genericDivWithId' and 'genericAHrefLink'
    public static final By promptAlert = By.xpath("//p/a[@id='prompt']");
    public static final By promptValueAlert = By.xpath("//p/a[@id='prompt-with-default']");
    public static final By doublePromptAlert = By.xpath("//p/a[@id='double-prompt']"); // not needed?
    public static final By slowAlert = By.xpath("//p/a[@id='slow-alert']");
    public static final By confirmAlert = By.xpath("//p/a[@id='confirm']");
    public static final By newPageAlert = By.xpath("//p/a[@id='open-page-with-onload-alert']");
    public static final By newWindowAlert = By.xpath("//p/a[@id='open-window-with-onload-alert']");
    public static final By dropdownAlert = By.xpath("//p/select[@id='select']");
    public static final By textboxAlert = By.xpath("//p/input[@id='input']");

    public static final By dropdownBox = By.xpath("");
    public static final By textBox = By.xpath("");

    //NOTE: in order to have a dynamic xpath we parse in a parameter to dynamically define the ID
    public static final String genericDivWithId = "//div[@id='%s']";
    public static final String genericAHrefLinkWithId = "//p/a[@id='%s']";


    public AlertPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("Testing Alerts", title);
    }

    @Override
    public void isLoaded() {
        getTitle();
    }

    public AlertPage clickDefaultAlert() {
        getLocatedElement(defaultAlert).click();
        return this;
    }

    public AlertPage clickEmptyAlert() {
        getLocatedElement(emptyAlert).click();
        return this;
    }

    public AlertPage clickAHrefWithId(String id) {
        getLocatedElement(genericAHrefLinkWithId.formatted(id)).click();
        return this;
    }

    public AlertPage assertAlert(String expected) {
        Alert alert = getAlertIsPresent();
        threadSleep(2000); //Give user time to see the message
        Assert.assertTrue(getAlertText(alert).contains(expected), "Alert does not contain the expected substring: " + expected);
        return this;
    }

    public AlertPage assertPromptAlertInputResult(String expected) {
        var promptText = getLocatedElement(genericDivWithId.formatted("text")).getText();
        Assert.assertEquals(promptText, expected);
        return this;
    }

    public AlertPage assertPromptAlertInputResult(String divId,String expected) {
        var promptText = getLocatedElement(genericDivWithId.formatted(divId)).getText();
        Assert.assertEquals(promptText, expected);
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
        return driverWait().until(ExpectedConditions.alertIsPresent());
    }

    private String getAlertText(Alert alert) {
        return alert.getText();
    }
}
