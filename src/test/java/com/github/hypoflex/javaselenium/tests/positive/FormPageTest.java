package com.github.hypoflex.javaselenium.tests.positive;

import com.github.hypoflex.javaselenium.Config;
import com.github.hypoflex.javaselenium.SetupTest;
import com.github.hypoflex.javaselenium.components.FormPage;
import com.github.hypoflex.javaselenium.components.ResultPage;
import org.testng.annotations.Test;

public class FormPageTest extends SetupTest {

    FormPage formPage;
    public FormPage openWebpage() {
        return openWebpage("formPage", FormPage.class);
    }

    @Test
    public void loginFormTest() {
        formPage = openWebpage();
        formPage.setLoginFormInputEmail(Config.INVALID_EMAIL_ADDRESS);
        formPage.setLoginFormInputAge(5);
        var resultPage = (ResultPage) formPage.submitLoginForm();
        resultPage.getParagraphText();
    }

    @Test
    public void imageFormTest() {
        formPage = openWebpage();
        var resultPage = (ResultPage) formPage.clickFormImageButton();
        resultPage.getParagraphText();
    }
}
