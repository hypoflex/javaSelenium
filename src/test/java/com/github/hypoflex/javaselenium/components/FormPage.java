package com.github.hypoflex.javaselenium.components;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FormPage extends Page {

    public FormPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "We Leave From Here");
    }

    @Override
    public void isLoaded() {
        getTitle();
    }
}
