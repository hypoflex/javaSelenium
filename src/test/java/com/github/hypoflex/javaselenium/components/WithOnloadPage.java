package com.github.hypoflex.javaselenium.components;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Slf4j
public class WithOnloadPage extends Page {

    public static final By paragraph = By.xpath("//p");
    public static final String PARAGRAPH_TEXT = "Page with onload event handler";

    public WithOnloadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {
        //There is no title
    }

    @Override
    public void isLoaded() {
        Assert.assertEquals(getLocatedElement(paragraph).getText(), PARAGRAPH_TEXT);
    }
}
