package com.ibm.backend.perutech.infrastructure.gateways;

import com.ibm.backend.perutech.application.gateways.UserGateway;
import com.ibm.backend.perutech.domain.entity.user.User;
import com.ibm.backend.perutech.domain.entity.user.dto.DUserRoleDto;
import com.ibm.backend.perutech.infrastructure.mapper.user.UserEntityMapper;
import com.ibm.backend.perutech.infrastructure.model.user.dto.IUserRoleDto;
import com.ibm.backend.perutech.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepositoryGateway implements UserGateway {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Boolean createUser(User userDomainObj) {
        return userRepository.save(userEntityMapper.toInfrastructureObj(userDomainObj));
    }

    @Override
    public List<DUserRoleDto> SelectUser() {
        List<IUserRoleDto> listUser = userRepository.findAll();
        return userEntityMapper.toDUserRoleListDto(listUser);
    }

}