package com.github.hypoflex.javaselenium.components;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Slf4j
public class FormPage extends Page {

    public FormPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        log.info("Page title: {}", title);
        Assert.assertEquals(title, "We Leave From Here");
    }

    @Override
    public void isLoaded() {
        getTitle();
    }
}
