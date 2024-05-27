package com.github.hypoflex.javaselenium.tests.positive;

import com.github.hypoflex.javaselenium.SetupTest;
import com.github.hypoflex.javaselenium.components.DynamicallyModifiedPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.github.hypoflex.javaselenium.components.Page.threadSleep;

@Slf4j
public class DynamicallyModifiedPageTest extends SetupTest {

    DynamicallyModifiedPage dynamicallyModifiedPage;
    public DynamicallyModifiedPage openWebpage() {
        return openWebpage("dynamicallyModifiedPage", DynamicallyModifiedPage.class);
    }

    //? declaring variables here is pure for demonstration purpose and should not be done.
    @Test
    public void newElementWithManualWait() {
        dynamicallyModifiedPage = openWebpage();
        Assert.assertEquals(dynamicallyModifiedPage.getOriginalElement(), "element");
        dynamicallyModifiedPage.clickRemoveButton();
        var waitTime = 5000;
        threadSleep(waitTime); // give the object some time to disappear
        log.info("Intentionally waiting for {} second(s)", waitTime);
        Assert.assertEquals(dynamicallyModifiedPage.getNewElement(), "new element");
    }

    @Test
    public void newElementWithAutomaticWait() {
        dynamicallyModifiedPage = openWebpage();
        Assert.assertEquals(dynamicallyModifiedPage.getOriginalElement(), "element");
        dynamicallyModifiedPage.clickRemoveButton();
        //? The getNewElement() uses Page#getLocatedElement() which keeps searching for new elements
        //? for a default of 5 seconds before it throws an error.
        Assert.assertEquals(dynamicallyModifiedPage.getNewElement(), "new element");
    }
}
