package com.promeethub_api.api.validation.contraint;

import com.promeethub_api.api.validation.validator.GreaterValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;


@Constraint(validatedBy = GreaterValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GreaterThan {

    String message() default "{max} must be greater than {min}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String min();

    String max();
}
