package com.promeethub_api.api.validation.validator;

import com.promeethub_api.api.validation.contraint.Tel;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TelValidator implements ConstraintValidator<Tel, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        return value.matches("^[0-9]{10}$");// 10 digit number only allowed in phone number
    }
}
