package com.ibm.backend.perutech.application.usecases;

import com.ibm.backend.perutech.application.gateways.UserGateway;
import com.ibm.backend.perutech.domain.entity.user.User;

public class CreateUserInteractor {
    private final UserGateway userGateway;

    public CreateUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Boolean createUser(User user) {
        return userGateway.createUser(user);
    }

}