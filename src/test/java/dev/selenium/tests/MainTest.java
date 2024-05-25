package dev.selenium.tests;

import dev.selenium.SetupTest;
import dev.selenium.components.*;
import org.testng.annotations.*;


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
    }
}