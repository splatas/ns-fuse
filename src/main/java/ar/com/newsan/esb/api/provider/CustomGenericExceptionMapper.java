package ar.com.newsan.esb.api.provider;

import ar.com.newsan.esb.utils.StandardResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.BeanInject;
import org.springframework.stereotype.Component;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@Component(value = "customExceptionMapper")
public class CustomGenericExceptionMapper implements ExceptionMapper<WebApplicationException> {

    @BeanInject
    private ObjectMapper mapper;

    @Override
    public Response toResponse(WebApplicationException e) {

        StandardResponse response = StandardResponse.error("NOT-DEFINED");
        response.registerError(e.getCause().getClass().getSimpleName(), e.getCause().getMessage());

        Response.ResponseBuilder builder = Response.fromResponse(e.getResponse());
        builder.header("Content-Type", "application/json");

        try { builder.entity(mapper.writeValueAsString(response)); }
        catch (Exception ex) { ex.printStackTrace(); }

        return builder.build();
    }
}
