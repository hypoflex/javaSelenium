package dev.selenium.components;

import org.openqa.selenium.WebDriver;

public abstract class Component {

    protected WebDriver driver;

    protected Component(WebDriver driver) {
        this.driver = driver;
    }
}