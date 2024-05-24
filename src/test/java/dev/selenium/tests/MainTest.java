package dev.selenium.tests;

import dev.selenium.Config;
import dev.selenium.SetupTest;
import dev.selenium.components.*;
import org.testng.annotations.*;

import static dev.selenium.components.Page.switchToNewTab;
import static dev.selenium.components.Page.threadSleep;

//? This class is for development purpose only, see package:
//? dev.selenium.tests.positive or .negative instead
public class MainTest extends SetupTest {

    AlertPage alertPage;
    public AlertPage openWebpage() {
        return openWebpage("alerts", AlertPage.class);
    }

    @Test
    public void newWindowAlertTest() {
        alertPage = openWebpage();
        alertPage.clickAHrefWithId("open-window-with-onload-alert");
        switchToNewTab();
        alertPage.assertAlert("onload").acceptAlert();
    }
}
