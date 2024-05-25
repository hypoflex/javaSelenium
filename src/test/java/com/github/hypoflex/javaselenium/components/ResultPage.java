package com.github.hypoflex.javaselenium.components;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Slf4j
public class ResultPage extends Page {

    public static final By paragraphText = By.xpath("//p[@id='greeting']");

    protected ResultPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        log.info("Page title: {}", title);
        Assert.assertEquals(title, "We Arrive Here");
    }

    @Override
    public void isLoaded() {
        getTitle();
    }

    public void getParagraphText() {
        Assert.assertEquals(getLocatedElement(paragraphText).getText(), "Success!");
    }
}
