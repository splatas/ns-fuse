package ar.com.newsan.esb.api.constraint;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = DateValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDate {

    String message() default "Neither semantic nor syntactic date validation have passed";

    String value() default "yyyy-MM-dd";

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};
}
