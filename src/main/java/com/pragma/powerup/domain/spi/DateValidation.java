package com.pragma.powerup.domain.spi;

import com.pragma.powerup.infrastructure.service.impl.DateValidationImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidationImpl.class)
@Documented
public @interface DateValidation {
    String message() default "El propietario debe ser mayor de edad";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
