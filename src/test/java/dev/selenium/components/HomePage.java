package dev.selenium.components;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals(title, "Index of Available Pages");
    }

    @Override
    public void isLoaded() {
        //Coming soon
    }

}
