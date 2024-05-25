package com.github.hypoflex.javaselenium.components;

import org.openqa.selenium.WebDriver;

public abstract class Component {

    protected static WebDriver driver;

    protected Component(WebDriver driver) {
        Component.driver = driver;
    }
}