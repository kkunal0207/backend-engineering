package com.springboot.week2.validation;

import com.springboot.week2.dto.EmployeeDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.Annotation;

public class RoleValidation implements ConstraintValidator<RoleValidator,String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        if(inputRole.equalsIgnoreCase("user") || inputRole.equalsIgnoreCase("admin")){
            return true;
        }
        return false;
    }
}
