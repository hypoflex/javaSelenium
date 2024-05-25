package com.github.hypoflex.javaselenium.components;

import com.github.hypoflex.javaselenium.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Slf4j
public class FormPage extends Page {

    private static final By loginFormInputEmail = By.xpath("//form[@name='login']//input[@type='email']");
    private static final By loginFormInputAge = By.xpath("//form[@name='login']//input[@type='email']");
    //? For ease of use, also here it's better to create some helper methods to define these xpath's more dynamically
    //? See 'defineXPathForm' for reference.

    public FormPage(WebDriver driver) {
        super(driver);
        isLoaded();
    }

    @Override
    public void getTitle() {
        String title = driver.getTitle();
        log.info("Page title: {}", title);
        Assert.assertEquals(title, "We Leave From Here");
    }

    @Override
    public void isLoaded() {
        getTitle();
    }

    public void setLoginFormInputEmail(String value) {
        getLocatedElement(defineXPathForm("login","input","id", "email")).sendKeys(value);
    }
    //? Give the user writing the test both options, string or int.
    //? in the end, the compiler expects a string due to it sending it as keys. but we allow both for more flexibility
    //? string is particularly helpful for negative testing.
    public void setLoginFormInputAge(String value) {
        getLocatedElement(defineXPathForm("login","input","id", "age")).sendKeys(value);
    }
    public void setLoginFormInputAge(int value) {
        getLocatedElement(defineXPathForm("login","input","id", "age")).sendKeys(String.valueOf(value));
    }


    public ResultPage submitLoginForm() {
        getLocatedElement(defineXPathForm("login","input","id", "submitButton")).click();
        return new ResultPage(driver);
    }

    public ResultPage clickFormImageButton() {
        getLocatedElement(defineXPathForm("image", "input", "type", "image")).click();
        return new ResultPage(driver);
    }

    //? This helper method allows us to define the form name, attribute type and attribute name dynamically.
    //? This helps to with easier and cleaner code.
    //? An example is that the xpath can be defined as: defineXpathForm("login", "input", "type", "email");
    //? resulting in the following xpath: //form[@name='login']//input[@type='email']
    private static By defineXPathForm(String formName, String elementName, String attributeType, String attributeValue) {
        String xpathExpression = "//form[@name='%s']//%s[@%s='%s']";
        return By.xpath(xpathExpression.formatted(formName, elementName, attributeType, attributeValue));
    }
}
