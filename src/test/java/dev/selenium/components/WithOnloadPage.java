package dev.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WithOnloadPage extends Page {

    public static final By paragraph = By.xpath("//p");
    public static final String paragraphText = "Page with onload event handler";

    public WithOnloadPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {

    }

    @Override
    public void isLoaded() {
        Assert.assertEquals(paragraphText, getLocatedElement(paragraph).getText());
    }
}
