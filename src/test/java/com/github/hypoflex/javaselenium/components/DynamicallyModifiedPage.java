package com.github.hypoflex.javaselenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DynamicallyModifiedPage extends Page {

    private static final By elementToRemove = By.xpath("//p[@id='element-to-remove']");
    private static final By removeElementButton = By.xpath("//form//input[@type='button']");


    public DynamicallyModifiedPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public void getTitle() {
        var title = driver.getTitle();
        Assert.assertEquals(title, "Delayed remove of an element");
    }

    @Override
    public void isLoaded() {
        getTitle();
    }

    public String getOriginalElement() {
        return getLocatedElement(elementToRemove).getText();
    }

    public String getNewElement() {
        return getLocatedElement(elementToRemove).getText();
    }

    public void clickRemoveButton() {
        getLocatedElement(removeElementButton).click();
        threadSleep(550); // element is hardcoded to disappear after 500 milliseconds
    }


}
