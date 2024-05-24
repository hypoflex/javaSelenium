package dev.selenium.components;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class Page extends Component {

    public Page(WebDriver driver) {
        super(driver);
    }

    protected File driverPath;
    protected File browserPath;

    public abstract void getTitle();

    public abstract void isLoaded();

    private static final Random rand = new Random();

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

    protected File getTempDirectory(String prefix) {
        File tempDirectory = null;
        try {
            tempDirectory = Files.createTempDirectory(prefix).toFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        tempDirectory.deleteOnExit();

        return tempDirectory;
    }

    protected File getTempFile(String prefix, String suffix) {
        File logLocation = null;
        try {
            logLocation = File.createTempFile(prefix, suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logLocation.deleteOnExit();

        return logLocation;
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

    public static void consoleLog(String logMessage) {
        System.out.println(logMessage);
    }

    public static void consoleLog(int logMessage) {
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
