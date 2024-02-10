package com.promeethub_api.api.validation.validator;

import com.promeethub_api.api.validation.contraint.Email;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null)
            return false;
        return value.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");// email pattern validation using regex expression

    }
}
