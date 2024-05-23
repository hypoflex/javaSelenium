package com.google.components;

import org.openqa.selenium.WebDriver;

public class SearchResults extends Page {

    protected SearchResults(WebDriver driver) {
        super(driver);
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        //TODO: Assert
    }

    @Override
    public void isLoaded() {}
}
