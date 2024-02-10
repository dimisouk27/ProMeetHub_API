package com.promeethub_api.api.validation.validator;

import com.promeethub_api.api.validation.contraint.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    private int minSize;
    private int maxSize;

    @Override
    public void initialize(Password constraintAnnotation) {
        this.minSize = constraintAnnotation.minLength();
        this.maxSize = constraintAnnotation.maxLength();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if( value == null )
            return false;

        String regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&=])[A-Za-z\\d@$!%*?&=]{"+minSize+","+maxSize+"}$";
        return value.matches(regexp);
    }
}
