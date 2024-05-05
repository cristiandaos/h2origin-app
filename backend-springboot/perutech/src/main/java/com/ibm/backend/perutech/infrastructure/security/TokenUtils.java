package com.ibm.backend.perutech.infrastructure.security;

import com.ibm.backend.perutech.infrastructure.model.Variables;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Date;

public class TokenUtils {

    /**
     * Este método crea un token JWT utilizando la información del usuario proporcionada.
     *
     * @param userDetails Un objeto User que contiene la información del usuario para la creación del token.
     * @return Una cadena que representa el token JWT generado.
     */
    public static String createToken(User userDetails){
        long expirationTime= Variables.ACCESS_TOKEN_VALIDITY_SECOND * 1_000;
        Date expirateDate= new Date(System.currentTimeMillis()+expirationTime);
        Collection<? extends GrantedAuthority> role = userDetails.getAuthorities();
        Claims claims= Jwts.claims()
                .add("email", userDetails.getUsername())
                .add("authorities",role)
                .build();

        return Jwts.builder()
                .subject(userDetails.getUsername())
                .expiration(expirateDate)
                .claims(claims)
                .issuedAt(new Date())
                .signWith(Keys.hmacShaKeyFor(Variables.ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

}
