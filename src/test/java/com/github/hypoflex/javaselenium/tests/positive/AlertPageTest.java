package com.github.hypoflex.javaselenium.tests.positive;

import com.github.hypoflex.javaselenium.SetupTest;
import com.github.hypoflex.javaselenium.components.AlertPage;
import org.testng.annotations.Test;

import static com.github.hypoflex.javaselenium.components.Page.threadSleep;

public class AlertPageTest extends SetupTest {

    AlertPage alertPage;
    public AlertPage openWebpage() {
        return openWebpage("alerts", AlertPage.class);
    }

    @Test
    public void defaultAlertTest() {
        alertPage = openWebpage();
        alertPage.clickDefaultAlert().assertAlert("cheese").acceptAlert();
    }

    @Test
    public void emptyAlertTest() {
        alertPage = openWebpage();
        alertPage.clickEmptyAlert().assertAlert("").acceptAlert();
    }

    @Test
    public void promptAlertTest() {
        alertPage = openWebpage();
        var inputText = "This is an input field";
        alertPage.clickAHrefWithId("prompt").assertAlert("Enter something").setPromptAlertInput(inputText).acceptAlert();
        alertPage.assertPromptAlertInputResult(inputText);
    }

    @Test
    public void promptDefaultValueAlertTest() {
        alertPage = openWebpage();
        alertPage.clickAHrefWithId("prompt-with-default").assertAlert("Enter something").dismissAlert();
        alertPage.assertPromptAlertInputResult("null");
    }

    @Test
    public void doublePromptAlertTest() {
        alertPage = openWebpage();
        var prompt1 = "This is prompt 1";
        var prompt2 = "This is prompt 2";

        alertPage.clickAHrefWithId("double-prompt");
        alertPage.assertAlert("First").setPromptAlertInput(prompt1).acceptAlert();
        threadSleep(2000);
        alertPage.assertAlert("Second").setPromptAlertInput(prompt2).acceptAlert();

        alertPage.assertPromptAlertInputResult("text1", prompt1);
        alertPage.assertPromptAlertInputResult("text2", prompt2);
    }

    @Test
    public void slowAlertTest() {
        alertPage = openWebpage();
        alertPage.clickAHrefWithId("slow-alert").assertAlert("Slow").acceptAlert();
    }

    @Test //TODO: Also accept and redirect
    public void confirmAlertTest() {
        alertPage = openWebpage();
        alertPage.clickAHrefWithId("confirm").dismissAlert();
    }

    @Test
    public void newPageAlertTest() {
        alertPage = openWebpage();
        alertPage.clickAHrefWithId("open-page-with-onload-alert").assertAlert("onload").acceptAlert();
    }

    @Test
    public void newWindowAlertTest() {
        alertPage = openWebpage();
        alertPage.clickAHrefWithId("open-window-with-onload-alert").assertAlert("onload").acceptAlert();
    }

    @Test
    public void dropdownAlertTest() {
        //TODO: Add
    }

    @Test
    public void textboxAlertTest() {
        //TODO: Add
    }
}
