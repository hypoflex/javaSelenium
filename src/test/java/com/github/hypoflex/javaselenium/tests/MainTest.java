package com.github.hypoflex.javaselenium.tests;

import com.github.hypoflex.javaselenium.SetupTest;
import com.github.hypoflex.javaselenium.components.*;
import org.testng.annotations.*;


//? This class is for development purpose only, see package:
//? com.github.hypoflex.javaselenium.tests.positive or .negative instead
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
