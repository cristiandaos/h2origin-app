package com.ibm.backend.perutech.infrastructure.gateways;

import com.ibm.backend.perutech.application.gateways.UserGateway;
import com.ibm.backend.perutech.domain.entity.User;
import com.ibm.backend.perutech.infrastructure.Repository.UserRepository;
import com.ibm.backend.perutech.infrastructure.mapper.user.UserEntityMapper;
import com.ibm.backend.perutech.infrastructure.model.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryGateway implements UserGateway {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public User createUser(User userDomainObj) {
        UserEntity savedEntity = userRepository.save(userEntityMapper.toEntity(userDomainObj));
        return userEntityMapper.toDomainObj(savedEntity);
    }

}