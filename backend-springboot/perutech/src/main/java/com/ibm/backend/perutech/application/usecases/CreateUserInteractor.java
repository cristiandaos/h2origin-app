package com.ibm.backend.perutech.application.usecases;

import com.ibm.backend.perutech.application.gateways.UserGateway;
import com.ibm.backend.perutech.domain.entity.User;

public class CreateUserInteractor {
    private final UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        return userGateway.createUser(user);
    }

}