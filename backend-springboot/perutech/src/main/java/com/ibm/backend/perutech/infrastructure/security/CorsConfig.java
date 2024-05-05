package com.ibm.backend.perutech.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    /**
     * Este método configura la política de intercambio de recursos entre diferentes orígenes (CORS) para las solicitudes HTTP en una aplicación Spring MVC.
     *
     * @return Un objeto WebMvcConfigurer que contiene la configuración CORS.
     */
   @Bean
    public WebMvcConfigurer corsConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/login/iniciarSesion")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*")
                        .exposedHeaders("*");

                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("*");
            }
        };
    }
}