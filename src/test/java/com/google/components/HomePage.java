package com.google.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends Page {

    private final By AcceptAllCookies = By.xpath("//div/button/div[contains(text(), 'Accept')]");
    private final By RejectAllCookies = By.xpath("//div/button/div[contains(text(), 'Reject')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("Google", title);
    }

    @Override
    public void isLoaded() {
        dynamicWait(By.name("q"));
    }

    public void acceptCookies() {
        dynamicWait(AcceptAllCookies);
        WebElement acceptButton = driver.findElement(AcceptAllCookies);
        acceptButton.click();
        threadSleep(2000); // Let the user actually see something!
    }

    public SearchResults performSearchWithCustomPrompt(String searchPrompt) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchPrompt);
        searchBox.submit();
        return new SearchResults(driver);
    }
}
