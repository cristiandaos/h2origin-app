package com.ibm.backend.perutech.application.gateways;

import com.ibm.backend.perutech.domain.entity.user.User;
import com.ibm.backend.perutech.domain.entity.user.dto.DUserRoleDto;

import java.util.List;

public interface UserGateway {
    Boolean createUser(User user);
    List<DUserRoleDto> SelectUser();
}
