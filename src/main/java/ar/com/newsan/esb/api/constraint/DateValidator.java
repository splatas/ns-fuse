package ar.com.newsan.esb.api.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator implements ConstraintValidator<ValidDate,String> {

    private String format;

    public void initialize(ValidDate constraintAnnotation) {
        format = constraintAnnotation.value();
    }

    public boolean isValid(String date, ConstraintValidatorContext constraintValidatorContext) {

        DateFormat dateFormat = new SimpleDateFormat(format);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true;
        }
        catch (ParseException e) {
            return false;
        }
    }
}
