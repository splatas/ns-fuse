package ar.com.newsan.esb.security;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.camel.Exchange;
import org.apache.camel.PropertyInject;

import javax.ws.rs.core.HttpHeaders;

import java.util.Calendar;
import java.util.Date;

import static ar.com.newsan.esb.security.JWTUtils.*;
import static javax.ws.rs.core.Response.Status.*;

public class JWTManager {

    // Configuration properties

    @PropertyInject(value = "custExpApiUsr") private String allowedUser;
    @PropertyInject(value = "custExpApiPwd") private String allowedPwd;
    @PropertyInject(value = "custExpApiSecret") private String key;
    @PropertyInject(value = "jwtId") private String jti;
    @PropertyInject(value = "jwtIssuer") private String iss;
    @PropertyInject(value = "jwtValidDays") private Integer days;

    public void getToken(Exchange exchange) {

        // Get the HTTP Authorization header from the request
        String authorizationHeader = exchange.getIn().getHeader(HttpHeaders.AUTHORIZATION, String.class);

        if(!isValidAuthentication(authorizationHeader, AUTHENTICATION_BASIC)) {
            abortWith(exchange, FORBIDDEN);
            return;
        }

        // Extract base64 encoded credentials from the HTTP Authorization header
        String encodedCredentials = authorizationHeader.substring(AUTHENTICATION_BASIC.length()).trim();

        try {
            // Decode credentials
            String credentials = new String(BaseEncoding.base64().decode(encodedCredentials));

            // Authenticate the user using the credentials provided
            authenticate(credentials);

            // Issue a token for the user
            String token = issueToken(credentials);

            // Return the token on the response
            exchange.getIn().setBody(token);

        } catch (Exception e) {

            abortWith(exchange, UNAUTHORIZED);
        }

    }

    private void authenticate(String credentials) {

        String allowed = String.format("%s:%s", allowedUser, allowedPwd);

        if(!credentials.equals(allowed))
            throw new RuntimeException("Bad Credentials");

    }

    private String issueToken(String credentials) {

        return Jwts.builder()
                .setId(jti)
                .setSubject(credentials)
                .setIssuer(iss)
                .setExpiration(nextWeek())
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
    }

    private Date nextWeek(){

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }

}
