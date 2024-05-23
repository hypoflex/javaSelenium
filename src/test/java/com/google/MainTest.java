package com.google;

import com.google.components.HomePage;
import org.testng.annotations.Test;

public class MainTest extends SetupTest {

    @Test
    public void performSearchTest() {
        var homePage = openWebpage();
        homePage.acceptCookies();
        var searchResults = homePage.performSearchWithCustomPrompt("Infomedics");
        // Add assertions here to validate search results
    }

    public HomePage openWebpage() {
        driver.get("http://www.google.com/");
        return new HomePage(driver);
    }
}
