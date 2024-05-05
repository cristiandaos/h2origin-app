package com.ibm.backend.perutech.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    /**
     * Este método devuelve el objeto AuthenticationManager que se utilizará para autenticar a los usuarios.
     *
     * @return El objeto AuthenticationManager utilizado para la autenticación de usuarios.
     * @throws Exception si ocurre un error al obtener el AuthenticationManager desde la configuración de autenticación.
     *
     * @description: Este método obtiene el AuthenticationManager desde la configuración de autenticación (authenticationConfiguration).
     * El AuthenticationManager es responsable de autenticar a los usuarios utilizando los proveedores de autenticación configurados.
     * Si ocurre un error al obtener el AuthenticationManager, se lanza una excepción.
     */
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Este método proporciona un bean de tipo PasswordEncoder que utiliza el algoritmo BCrypt para cifrar contraseñas.
     * Se utiliza para cifrar y validar las contraseñas almacenadas en la base de datos.
     *
     * @return Un objeto PasswordEncoder que utiliza el algoritmo BCrypt para cifrar contraseñas.
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Este método proporciona un bean de tipo SecurityFilterChain que configura la seguridad de la aplicación.
     *
     * @param http Un objeto HttpSecurity que se utiliza para configurar la seguridad HTTP.
     * @return Un objeto SecurityFilterChain que define la configuración de seguridad para la aplicación.
     * @throws Exception si ocurre un error durante la configuración de la seguridad.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return  http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(HttpMethod.POST, "/api/v1/user/create").permitAll();
                    authorize.anyRequest().authenticated();
                })
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .build();
    }

}