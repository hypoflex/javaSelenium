package dev.selenium.components.exceptions;

public class PageObjectCreationException extends RuntimeException {
    public PageObjectCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}
