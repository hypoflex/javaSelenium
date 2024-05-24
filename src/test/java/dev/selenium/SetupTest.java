package dev.selenium;

import dev.selenium.components.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SetupTest {

    protected WebDriver driver;

    // For testing purpose we Start and Stop the driver for each method.
    // This is done due to the tests being relatively small.
    // This setup also allows to very quickly run each test is Parallel
    @BeforeMethod
    public void setupDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        try {
            System.out.println("Starting the driver.");
            driver = new ChromeDriver();
            //driver.manage().window().maximize(); //for testing purpose disabled
        } catch (Exception e) {
            throw new Exception("Failed to start the driver.", e);
        }
    }

    // A helper class to dynamically create pages that extend the 'Page Class'
    // This removes the purpose of having to navigate through the homepage first each time.
    public <T extends Page> T openWebpage(String pageName, Class<T> pageClass) {
        driver.get(String.format("https://www.selenium.dev/selenium/web/%s.html", pageName));
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page object", e);
        }
    }

    @AfterMethod
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
