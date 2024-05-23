package com.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SetupTest {

    protected WebDriver driver;

    @BeforeClass
    public void setupDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        try {
            System.out.println("Starting the driver.");
            driver = new ChromeDriver();
            //driver.manage().window().maximize();
        } catch (Exception e) {
            throw new Exception("Failed to start the driver.", e);
        }
    }

    //@AfterClass
    public void tearDown() throws Exception {
        try {
            if (driver != null) {
                driver.quit();
                System.out.println("Driver is being quit, browser shutdown.");
            }
        } catch (Exception e) {
            throw new Exception("Failed to quit the driver.", e);
        }
    }
}
