package com.ibm.backend.perutech.infrastructure.security.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.backend.perutech.infrastructure.model.Message;
import com.ibm.backend.perutech.infrastructure.model.Variables;
import com.ibm.backend.perutech.infrastructure.model.authentication.AuthCredentials;
import com.ibm.backend.perutech.infrastructure.security.TokenUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Este método se llama cuando se intenta autenticar al usuario utilizando las credenciales proporcionadas en la solicitud HTTP.
     *
     * @param request HttpServletRequest proporciona acceso a la solicitud HTTP actual.
     * @param response HttpServletResponse proporciona acceso a la respuesta HTTP actual.
     * @return Authentication que representa la autenticación exitosa.
     * @throws AuthenticationException si no se puede autenticar al usuario con las credenciales proporcionadas.
     *
     * @description: En este método, se intenta leer las credenciales de autenticación proporcionadas en el cuerpo de la solicitud HTTP.
     * Estas credenciales se leen y se mapean a un objeto AuthCredentials utilizando ObjectMapper.
     * A continuación, se crea un objeto UsernamePasswordAuthenticationToken utilizando las credenciales mapeadas.
     * Finalmente, se utiliza el AuthenticationManager para autenticar al usuario utilizando el token de autenticación.
     * Si la autenticación es exitosa, se devuelve el resultado de la autenticación.
     * Si no se puede autenticar al usuario, se lanza una AuthenticationException.
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AuthCredentials authCredentials = new AuthCredentials();
        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                authCredentials.getUsername(),
                authCredentials.getPassword()
        );
        return authenticationManager.authenticate(authenticationToken);
    }

    /**
     * Este método se llama cuando la autenticación del usuario tiene éxito,
     * es decir, cuando el usuario es autenticado correctamente.
     *
     * @param request HttpServletRequest proporciona acceso a la solicitud HTTP actual.
     * @param response HttpServletResponse proporciona acceso a la respuesta HTTP actual.
     * @param chain FilterChain proporciona acceso al siguiente filtro en la cadena de filtros.
     * @param authResult Authentication que contiene la información de autenticación exitosa.
     * @throws IOException si ocurre un error de entrada/salida al escribir en el flujo de salida.
     * @throws ServletException si ocurre un error durante el procesamiento del servlet.
     *
     * @description: En este método, se genera un token de acceso para el usuario autenticado.
     * Este token se añade como encabezado de autorización en la respuesta HTTP.
     * Además, se crea un mapa que contiene el token de acceso, el nombre de usuario y un mensaje de éxito.
     * Este mapa se convierte a formato JSON y se envía como respuesta al cliente.
     * Se establece el tipo de contenido de la respuesta como "application/json".
     * Además, se establece el código de estado de la respuesta como 200 (Éxito) para indicar que la autenticación fue exitosa.
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();
        String token = TokenUtils.createToken(user);
        response.addHeader(Variables.HEADER_AUTHORIZATION, Variables.PREFIX_TOKEN + token);
        Map<String, String> body = new HashMap<>();
            body.put("token", token);
            body.put("email", user.getUsername());
            body.put("message",Message.SUCCESS_LOGIN.getMessage());
            body.put("status",Message.HTTP_STATUS_200.getMessage());
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setContentType(Variables.CONTENT_TYPE);
        response.setStatus(HttpStatus.OK.value());
    }

    /**
     * Este método se llama cuando la autenticación del usuario no tiene éxito,
     * es decir, cuando el usuario no puede ser autenticado correctamente.
     *
     * @param request HttpServletRequest proporciona acceso a la solicitud HTTP actual.
     * @param response HttpServletResponse proporciona acceso a la respuesta HTTP actual.
     * @param failed AuthenticationException que indica el motivo del fallo de autenticación.
     * @throws IOException si ocurre un error de entrada/salida al escribir en el flujo de salida.
     * @throws ServletException si ocurre un error durante el procesamiento del servlet.
     *
     * @description: En este método, se crea un mapa que contiene un mensaje de error y detalles adicionales sobre el fallo de autenticación.
     * Este mapa se convierte a formato JSON y se envía como respuesta al cliente.
     * Se establece el tipo de contenido de la respuesta como "application/json".
     * Además, se establece el código de estado de la respuesta como 401 (No autorizado) para indicar que la autenticación no fue exitosa.
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Map<String, String> body = new HashMap<>();
            body.put("message", Message.INVALID_LOGIN.getMessage());
            body.put("status", Message.HTTP_STATUS_401.getMessage()); //+ failed.getMessage());
        response.getWriter().write(new ObjectMapper().writeValueAsString(body));
        response.setContentType(Variables.CONTENT_TYPE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}