package dev.selenium.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResultPage extends Page {

    public static final By paragraphText = By.xpath("//p[@id='greetings'");

    protected ResultPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "We Arrive Here");
    }

    @Override
    public void isLoaded() {
        getTitle();
        getParagraphText();
    }

    public void getParagraphText() {
        Assert.assertEquals("Success!", getLocatedElement(paragraphText).getText());
    }
}
