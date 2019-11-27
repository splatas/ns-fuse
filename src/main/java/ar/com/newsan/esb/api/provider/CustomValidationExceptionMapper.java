package ar.com.newsan.esb.api.provider;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.apache.camel.BeanInject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import ar.com.newsan.esb.utils.StandardResponse;

@Component(value = "validationExceptionMapper")
public class CustomValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @BeanInject
    private ObjectMapper mapper;

    @Override
    public Response toResponse(ValidationException exception) {

        StandardResponse response = StandardResponse.error("NOT-DEFINED");

        if (exception instanceof ConstraintViolationException) {

            ConstraintViolationException constraint = (ConstraintViolationException)exception;

            for(ConstraintViolation cv : constraint.getConstraintViolations()) {
                response.registerError(constraint.getClass().getSimpleName(),
                        String.format("%s %s (value = %s)", cv.getPropertyPath(), cv.getMessage(), String.valueOf(cv.getInvalidValue())));
            }

        }
        else //Any other validation exception
            response.registerError(exception.getClass().getSimpleName(), exception.getMessage());

        Response.ResponseBuilder builder = Response.status(Response.Status.BAD_REQUEST);
        builder.header("Content-Type", "application/json");

        try { builder.entity(mapper.writeValueAsString(response)); }
        catch (Exception ex) { ex.printStackTrace(); }

        return builder.build();
    }
}
