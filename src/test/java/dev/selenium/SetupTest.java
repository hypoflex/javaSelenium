package dev.selenium;

import dev.selenium.components.Page;
import dev.selenium.components.exceptions.PageObjectCreationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class SetupTest {

    protected WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(SetupTest.class);

    //? For testing purpose we Start and Stop the driver for each method.
    //? This is done due to the tests being relatively small.
    //? This setup also allows to very quickly run each test is Parallel
    @BeforeMethod
    public void setupDriver() throws WebDriverException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        try {
            LOGGER.info("Starting the driver.");
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
                LOGGER.info("Driver is being quit, browser shutdown.");
            }
        } catch (Exception e) {
            throw new WebDriverException("Failed to quit the driver.", e);
        }
    }
}
