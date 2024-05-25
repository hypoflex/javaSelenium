package dev.selenium.tests.positive;

import dev.selenium.SetupTest;
import dev.selenium.components.FormPage;
import org.testng.annotations.Test;

public class FormPageTest extends SetupTest {

    FormPage formPage;
    public FormPage openWebpage() {
        return openWebpage("alerts", FormPage.class);
    }

    @Test
    public void defaultAlertTest() {
        formPage = openWebpage();
    }
}
