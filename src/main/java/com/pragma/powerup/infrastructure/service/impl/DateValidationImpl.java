package com.pragma.powerup.infrastructure.service.impl;

import com.pragma.powerup.domain.spi.DateValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateValidationImpl implements ConstraintValidator<DateValidation, LocalDate> {
    @Override
    public void initialize(DateValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {
        if (date == null) {
            return true;
        }

        LocalDate actualDate = LocalDate.now();
        LocalDate minusYears = actualDate.minusYears(18);

        return date.isBefore(minusYears);
    }
}
