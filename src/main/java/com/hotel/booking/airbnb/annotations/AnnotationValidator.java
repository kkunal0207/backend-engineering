package com.hotel.booking.airbnb.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class AnnotationValidator implements ConstraintValidator<CustomAnnotationValidation,String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        if(inputRole == null) return false;
        List<String> roles = List.of("USER","ADMIN");
        return roles.contains(inputRole);
    }
}
