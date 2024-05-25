package com.github.hypoflex.javaselenium;

import com.github.hypoflex.javaselenium.components.Page;
import com.github.hypoflex.javaselenium.components.exceptions.PageObjectCreationException;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

@Slf4j
public class SetupTest {

    protected WebDriver driver;

    //? For testing purpose we Start and Stop the driver for each method.
    //? This is done due to the tests being relatively small.
    //? This setup also allows to very quickly run each test is Parallel
    @BeforeMethod
    public void setupDriver() throws WebDriverException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        try {
            log.info("Starting the driver.");
            driver = new ChromeDriver();
            //driver.manage().window().maximize(); //for testing purpose disabled
        } catch (Exception e) {
            throw new WebDriverException("Failed to start the driver.", e);
        }
    }

    //? A helper class to dynamically create pages that extend the 'Page Class'
    //? This removes the purpose of having to navigate through the homepage first each time.
    public <T extends Page> T openWebpage(String pageName, Class<T> pageClass) {
        driver.get(String.format("https://www.selenium.dev/selenium/web/%s.html", pageName));
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new PageObjectCreationException("Failed to create page object", e);
        }
    }

    @AfterMethod
    public void tearDown() throws WebDriverException {
        try {
            if (driver != null) {
                driver.quit();
                log.info("Driver is being quit, browser shutdown.");
            }
        } catch (Exception e) {
            throw new WebDriverException("Failed to quit the driver.", e);
        }
    }
}
