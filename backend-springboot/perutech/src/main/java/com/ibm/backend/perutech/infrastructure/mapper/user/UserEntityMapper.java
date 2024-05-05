package com.ibm.backend.perutech.infrastructure.mapper.user;

import com.ibm.backend.perutech.domain.entity.User;
import com.ibm.backend.perutech.infrastructure.model.user.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(
                user.UserId(),
                user.Name(),
                user.LastName(),
                user.Email(),
                user.Phone(),
                user.Age(),
                user.Gender(),
                user.Password(),
                user.RecoveryEmail(),
                user.District(),
                user.CountryOrigin(),
                user.AccountStatus(),
                user.RoleId(),
                user.CreatedBy(),
                user.CreationDate(),
                user.UpdatedBy(),
                user.UpdateDate(),
                user.DeletedBy(),
                user.DeletionDate()
        );
    }

    public User toDomainObj(UserEntity userEntity) {
        return new User(
                userEntity.getUserId(),
                userEntity.getName(),
                userEntity.getLastName(),
                userEntity.getEmail(),
                userEntity.getPhone(),
                userEntity.getAge(),
                userEntity.getGender(),
                userEntity.getPassword(),
                userEntity.getRecoveryEmail(),
                userEntity.getDistrict(),
                userEntity.getCountryOrigin(),
                userEntity.getAccountStatus(),
                userEntity.getRoleId(),
                userEntity.getCreatedBy(),
                userEntity.getCreationDate(),
                userEntity.getUpdatedBy(),
                userEntity.getUpdateDate(),
                userEntity.getDeletedBy(),
                userEntity.getDeletionDate()
        );
    }

}
