package ar.com.newsan.esb.security;

import org.apache.camel.Exchange;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;

public abstract class JWTUtils {

    public static final String AUTHENTICATION_BEARER= "Bearer";
    public static final String AUTHENTICATION_BASIC= "Basic";

    // Util methods

    public static boolean isValidAuthentication(String header, String type) {

        // Authorization header must not be null and must be prefixed with given type plus a whitespace (case-insensitive)
        return header != null &&
                header.toLowerCase().startsWith(type.toLowerCase() + " ");
    }

    public static void abortWith(ContainerRequestContext ctx, Response.Status status) {

        ctx.abortWith(Response.status(status).build());
    }

    public static void abortWith(Exchange exchange, Response.Status status) {

        exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, status.getStatusCode());
        exchange.getIn().setFault(true);
    }

}
