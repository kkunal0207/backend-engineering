package com.springboot.week2.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RoleValidation.class)
public @interface RoleValidator {
    String message() default "{User Role can be only USER or ADMIN}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
