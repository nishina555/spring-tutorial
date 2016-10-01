package com.example.reservation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

/**
 * Created by nishina on 2016/09/30.
 */
public class ThirtyMinutesUnitValidator implements ConstraintValidator<ThirtyMinutesUnit, LocalTime> {
    @Override
    public void initialize(ThirtyMinutesUnit constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalTime value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return value.getMinute() % 30 == 0;
    }

}
