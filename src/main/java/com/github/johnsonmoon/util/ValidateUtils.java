package com.github.johnsonmoon.util;

import com.github.johnsonmoon.entity.PropertyError;
import com.github.johnsonmoon.entity.ValidateResult;
import org.hibernate.validator.HibernateValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Create by xuyh at 2019/9/23 10:24.
 */
public class ValidateUtils {
    private static Logger logger = LoggerFactory.getLogger(ValidateUtils.class);
    private static Validator validator;

    static {
        try {
            validator = Validation.byProvider(HibernateValidator.class).configure().failFast(false).buildValidatorFactory().getValidator();
        } catch (Exception e) {
            logger.warn(e.getMessage(), e);
        }
    }

    public static <T> ValidateResult<T> validate(T source) {
        if (validator == null) {
            logger.warn("No validator available!");
            return null;
        }
        Set<ConstraintViolation<Object>> errors = validator.validate(source);
        ValidateResult<T> validateResult = new ValidateResult<>();
        validateResult.source(source);
        if (errors != null && !errors.isEmpty()) {
            List<PropertyError> propertyErrors = new ArrayList<>();
            for (ConstraintViolation<Object> error : errors) {
                propertyErrors.add(new PropertyError()
                        .property(error.getPropertyPath().toString())
                        .message(error.getMessage())
                        .invalidValue(error.getInvalidValue()));
            }
            validateResult.success(false);
            validateResult.propertyErrors(propertyErrors);
        } else {
            validateResult.success(true);
        }
        return validateResult;
    }
}
