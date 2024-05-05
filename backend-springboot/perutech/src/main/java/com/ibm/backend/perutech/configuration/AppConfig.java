package com.ibm.backend.perutech.configuration;

import com.ibm.backend.perutech.application.gateways.UserGateway;
import com.ibm.backend.perutech.application.usecases.CreateUserInteractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /**
     * Método de configuración que crea y configura un bean CreateUserInteractor para poder injectar
     */
    @Bean
    public CreateUserInteractor createUserInteractor(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }
}
