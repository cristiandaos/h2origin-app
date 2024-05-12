package com.ibm.backend.perutech.infrastructure.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.backend.perutech.infrastructure.model.Message;
import com.ibm.backend.perutech.infrastructure.model.Variables;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class JwtValidationFilter extends BasicAuthenticationFilter {

    public JwtValidationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(Variables.HEADER_AUTHORIZATION);
        //validar que sea distinto a nulo porque podría ser una ruta publica  ||  que venga con autorización pero sin la palabra "Bearer "
        if (header == null || !header.startsWith(Variables.PREFIX_TOKEN)) {
            chain.doFilter(request, response);
            return;
        }
        String token = header.replace(Variables.PREFIX_TOKEN, "");
        try {
            //Obtenemos el payload es decir los valores del Jwts.builder() -> TokenUtils
            Claims claims = Jwts.parser().verifyWith(Variables.ACCESS_TOKEN_SECRET).build().parseSignedClaims(token).getPayload();
            //String email = claims.getSubject();
            String email = (String) claims.get("email");
            Object authoritiesClaims = claims.get("authorities");
            Collection<? extends GrantedAuthority> authorities = Arrays.asList(
                    new ObjectMapper()
                            .addMixIn(SimpleGrantedAuthority.class, SimpleGrantedAuthorityJsonCreator.class)
                            .readValue(authoritiesClaims.toString().getBytes(), SimpleGrantedAuthority[].class)
            );
            //iniciamos sesion
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            chain.doFilter(request, response);
        } catch (JwtException e) {
            Map<String, String> body = new HashMap<>();
            body.put("error", e.getMessage());
            body.put("message", Message.INVALID_TOKEN.getMessage());
            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setContentType(Variables.CONTENT_TYPE);

        }
    }
}
