package com.google.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public abstract class Page extends Component {

    protected Page(WebDriver driver) {
        super(driver);
    }

    public abstract void getTitle();
    public abstract void isLoaded();

    private static final Random rand = new Random();

    // **************** CUSTOM SYSTEM FUNCTIONS **************** //

    public WebElement dynamicWait(By xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(xpath));
    }

    public WebElement dynamicWait(String xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath))));
    }

    public WebElement dynamicWait(By xpath, int maximumDuration) {
        return new WebDriverWait(driver, Duration.ofSeconds(maximumDuration)).until(ExpectedConditions.presenceOfElementLocated((xpath)));
    }

    public WebElement dynamicWait(String xpath, int maximumDuration) {
        return new WebDriverWait(driver, Duration.ofSeconds(maximumDuration)).until(ExpectedConditions.presenceOfElementLocated((By.xpath(xpath))));
    }

    public WebDriverWait customWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebDriverWait customWait(int durationOfSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
    }

    public String xpathStringBuilder(String... args) {
        String newString = String.join(",", args);
        return String.format("(%s)", newString);
    }

    public String xpathContains(String key, String value) {
        return String.format("[contains (%s,'%s')]", key, value);
    }

    public String xpathIndex(int index) {
        return String.format("[%d]", index);
    }

    public static String stringFormatter(String string, String value) {
        return String.format(string, value);
    }

    public int randomNumberGenerator(By byXpathObject) {
        int max = driver.findElements(byXpathObject).size();
        int min = 1;
        return rand.nextInt((max - min) + 1) + min;
    }
    public int randomNumberGenerator(String byXpathString) {
        int max = driver.findElements(By.xpath(byXpathString)).size();
        int min = 1;
        return rand.nextInt((max - min) + 1) + min;
    }

    public int randomNumberGenerator(int min, By byXpathObject) {
        int max = driver.findElements(byXpathObject).size();
        return rand.nextInt((max - min) + 1) + min;
    }

    public int randomNumberGenerator(int min, String byXpathString) {
        int max = driver.findElements(By.xpath(byXpathString)).size();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static <T> T getRandomFromList(List<T> list) {
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public static void systemLogger(String logMessage) {
        System.out.println(logMessage);
    }

    public static void systemLogger(int logMessage) {
        System.out.println(logMessage);
    }

    public static void threadSleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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
