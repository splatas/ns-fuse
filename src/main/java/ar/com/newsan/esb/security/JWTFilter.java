package ar.com.newsan.esb.security;

import io.jsonwebtoken.Jwts;
import org.apache.camel.PropertyInject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;

import static ar.com.newsan.esb.security.JWTUtils.*;
import static javax.ws.rs.core.Response.Status.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.AUTHENTICATION)
@JWTSecured
public class JWTFilter implements ContainerRequestFilter {

    private Logger LOGGER = LoggerFactory.getLogger(JWTFilter.class);

    @PropertyInject(value = "custExpApiSecret") private String key;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {

        // Get the HTTP Authorization header from the request
        String authorizationHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if(!isValidAuthentication(authorizationHeader, AUTHENTICATION_BEARER)) {
            abortWith(containerRequestContext, UNAUTHORIZED);
            return;
        }

        // Extract the token from the HTTP Authorization header
        String token = authorizationHeader.substring(AUTHENTICATION_BEARER.length()).trim();

        try {

            validateToken(token);

            LOGGER.info("[VALIDATE TOKEN] Supplied token is valid");

        } catch (Exception e) {

            LOGGER.error("[VALIDATE TOKEN] Supplied token is invalid");

            abortWith(containerRequestContext, UNAUTHORIZED);

        }

    }

    private void validateToken(String token) {

        // Validate the token
        Jwts.parser().setSigningKey(key).parseClaimsJws(token);
    }

}
