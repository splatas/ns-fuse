package ar.com.newsan.esb.utils;

import javax.validation.ConstraintViolation;

import org.apache.camel.Exchange;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.apache.ibatis.exceptions.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Class which handles exceptions
 *
 * @author Ingenia CA
 * @version 0.1
 * @since 2017-12-13
 */
@Component(value = "handler")
public class ExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);
    private final static String VALIDATION_EXCEPTION_FORMAT = "%s %s (value = %s)";

    /**
     * In case of {@link JsonProcessingException}. Syntactic exception
     *
     * @param exchange
     */
    public void parseException(Exchange exchange) {
        JsonProcessingException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, JsonProcessingException.class);
        String currentOperation = getCurrentOperation(exchange);
        LOG.error(String.format("Parse exception - operation: %s", currentOperation), exception);

        StandardResponse response = StandardResponse.error(currentOperation);
        response.registerError(exception.getClass().getSimpleName(),
                "Submitted JSON is invalid");

        exchange.getIn().setBody(response);
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);
    }

    /**
     * In case of generic {@link Exception}
     *
     * @param exchange
     */
    public void genericException(Exchange exchange) {
        Exception exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
        String currentOperation = getCurrentOperation(exchange);
        LOG.error(String.format("Generic exception - operation: %s", currentOperation), exception);

        StandardResponse<Object> response = StandardResponse.error(currentOperation);
        response.registerError(exception.getClass().getSimpleName(),
                "Internal Server Error - An unexpected exception has been caught");

        exchange.getIn().setBody(response);
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
    }

    /**
     * In case of {@link BeanValidationException}. Semantic exception
     *
     * @param exchange
     */
    public void validationException(Exchange exchange) {
        BeanValidationException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, BeanValidationException.class);
        String currentOperation = getCurrentOperation(exchange);
        LOG.error(String.format("Validation exception - operation: %s", currentOperation), exception);

        StandardResponse response = StandardResponse.error(currentOperation);
        for (ConstraintViolation cv : exception.getConstraintViolations()) {
            response.registerError(exception.getClass().getSimpleName(), String.format(VALIDATION_EXCEPTION_FORMAT, cv.getPropertyPath(), cv.getMessage(), String.valueOf(cv.getInvalidValue())));
        }

        exchange.getIn().setBody(response);
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 422);
    }

    // Custom exceptions

    public void persistenceException(Exchange exchange) {
        PersistenceException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, PersistenceException.class);
        String currentOperation = getCurrentOperation(exchange);
        LOG.error(String.format("MyBatis exception - operation: %s", currentOperation), exception);

        StandardResponse response = StandardResponse.error(currentOperation);
        response.registerError(exception.getClass().getSimpleName(), exception.getMessage());

        exchange.getIn().setBody(response);
        exchange.getIn().setHeader(Exchange.CONTENT_TYPE, "application/json");
        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, 500);
    }

    // Utils

    private String getCurrentOperation(Exchange exchange) {
        return exchange.getProperty("currentOperation", "NOT-DEFINED", String.class);
    }

}
