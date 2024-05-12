package com.ibm.backend.perutech.application.usecases;

import com.ibm.backend.perutech.application.gateways.UserGateway;
import com.ibm.backend.perutech.domain.entity.user.dto.DUserRoleDto;

import java.util.List;

public class SelectUserInteractor {
    private final UserGateway userGateway;

    public SelectUserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<DUserRoleDto> SelectUser(){
        return userGateway.SelectUser();
    }

}
