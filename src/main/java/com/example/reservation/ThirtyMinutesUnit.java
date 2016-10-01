package com.example.reservation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by nishina on 2016/09/30.
 */
@Documented
@Constraint(validatedBy = { ThirtyMinutesUnitValidator.class})
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface ThirtyMinutesUnit {
    String message() default "{com.example.reservation.ThirtyMinuteUnit.message}";

    Class<?>[]groups() default {};

    Class<? extends Payload>[]payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        ThirtyMinutesUnit[]value();
    }
}
