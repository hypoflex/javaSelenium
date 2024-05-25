package com.github.hypoflex.javaselenium.tests.positive;

import com.github.hypoflex.javaselenium.SetupTest;
import com.github.hypoflex.javaselenium.components.FormPage;
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
