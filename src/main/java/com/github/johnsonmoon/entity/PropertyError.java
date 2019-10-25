package com.github.johnsonmoon.entity;

/**
 * Create by xuyh at 2019/10/25 16:58.
 */
public class PropertyError {
    /**
     * Property where validate failed.
     */
    private String property;
    /**
     * Error message.
     */
    private String message;
    /**
     * Invalid value for this property.
     */
    private Object invalidValue;

    public String getProperty() {
        return property;
    }

    public PropertyError property(String property) {
        this.property = property;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public PropertyError message(String message) {
        this.message = message;
        return this;
    }

    public Object getInvalidValue() {
        return invalidValue;
    }

    public PropertyError invalidValue(Object invalidValue) {
        this.invalidValue = invalidValue;
        return this;
    }

    @Override
    public String toString() {
        return "PropertyError{" +
                "property='" + property + '\'' +
                ", message='" + message + '\'' +
                ", invalidValue=" + invalidValue +
                '}';
    }
}
