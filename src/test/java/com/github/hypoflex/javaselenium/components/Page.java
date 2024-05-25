package com.github.hypoflex.javaselenium.components;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

@Slf4j
public abstract class Page extends Component {


    protected Page(WebDriver driver) {
        super(driver);
    }

    public abstract void getTitle();

    public abstract void isLoaded();


    // **************** CUSTOM SYSTEM FUNCTIONS **************** //

    public WebElement getLocatedElement(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(d -> driver.findElement(by));
    }

    public WebElement getLocatedElement(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(d -> driver.findElement(by));
    }

    public WebElement getLocatedElement(String xpathString) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(d -> driver.findElement(By.xpath(xpathString)));
    }

    public WebElement getLocatedElement(String xpathString, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(d -> driver.findElement(By.xpath(xpathString)));
    }

    public static void switchToNewTab() {
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for(String windowHandle : allWindows) {
            if(!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }


    // **************** CUSTOM SYSTEM FUNCTIONS **************** //


    public WebDriverWait driverWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebDriverWait driverWait(int durationOfSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
    }

    public String xpathContains(String key, String value) {
        return String.format("[contains (%s,'%s')]", key, value);
    }

    public String xpathIndex(int index) {
        return String.format("[%d]", index);
    }

    public static void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            log.warn("Thread was interrupted!", e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        }
    }

    public void pageScrollBottom(By pageElement) {
        WebElement element = driver.findElement(pageElement);
        element.click();
        for (int i = 0; i < 5; i++) {
            new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        }
    }

    public void pageScrollBottom(String pageElement) {
        WebElement element = driver.findElement(By.xpath(pageElement));
        element.click();
        for (int i = 0; i < 5; i++) {
            new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
        }
    }



}
