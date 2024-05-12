package com.ibm.backend.perutech.infrastructure.model;

import io.jsonwebtoken.Jwts;

import javax.crypto.SecretKey;

/**
 * Clase que contiene constantes utilizadas en la aplicación.
 */
public class Variables {
    public final static SecretKey ACCESS_TOKEN_SECRET = Jwts.SIG.HS256.key().build();
    public final static Long ACCESS_TOKEN_VALIDITY_SECOND = 259200000L;
    public final static String PREFIX_TOKEN = "Bearer ";
    public final static String HEADER_AUTHORIZATION = "Authorization";
    public final static String CONTENT_TYPE = "application/json";
}
