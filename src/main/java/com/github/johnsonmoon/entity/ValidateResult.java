package com.github.johnsonmoon.entity;

import java.util.List;

/**
 * Create by xuyh at 2019/10/25 16:59.
 */
public class ValidateResult<T> {
    /**
     * The source object tobe validated.
     */
    private T source;
    /**
     * Validate result, true: success, false: failed.
     */
    private Boolean success;
    /**
     * Detail information if validate failed.
     */
    private List<PropertyError> propertyErrors;

    public T getSource() {
        return source;
    }

    public ValidateResult source(T source) {
        this.source = source;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public ValidateResult success(Boolean success) {
        this.success = success;
        return this;
    }

    public List<PropertyError> getPropertyErrors() {
        return propertyErrors;
    }

    public ValidateResult propertyErrors(List<PropertyError> propertyErrors) {
        this.propertyErrors = propertyErrors;
        return this;
    }

    @Override
    public String toString() {
        return "ValidateResult{" +
                "source=" + source +
                ", success=" + success +
                ", propertyErrors=" + propertyErrors +
                '}';
    }
}
