package com.ibm.backend.perutech.application.gateways;

import com.ibm.backend.perutech.domain.entity.User;

public interface UserGateway {
    User createUser(User user);
}
