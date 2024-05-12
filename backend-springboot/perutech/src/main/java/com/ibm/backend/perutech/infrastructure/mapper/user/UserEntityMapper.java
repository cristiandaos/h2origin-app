package com.ibm.backend.perutech.infrastructure.mapper.user;

import com.ibm.backend.perutech.domain.entity.user.User;
import com.ibm.backend.perutech.domain.entity.user.dto.DUserRoleDto;
import com.ibm.backend.perutech.infrastructure.model.user.UserEntity;
import com.ibm.backend.perutech.infrastructure.model.user.dto.IUserRoleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserEntityMapper {

    public UserEntity toInfrastructureObj(User user) {
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

    //DTO
    public DUserRoleDto toDUserRoleDto(IUserRoleDto user) {
        return new DUserRoleDto(
                user.Name(),
                user.LastName(),
                user.Email(),
                user.Phone(),
                user.Age(),
                user.Gender(),
                user.RecoveryEmail(),
                user.District(),
                user.CountryOrigin(),
                user.AccountStatus(),
                user.RoleName()
        );
    }

    public IUserRoleDto toIUserRoleDto(DUserRoleDto user) {
        return new IUserRoleDto(
                user.Name(),
                user.LastName(),
                user.Email(),
                user.Phone(),
                user.Age(),
                user.Gender(),
                user.RecoveryEmail(),
                user.District(),
                user.CountryOrigin(),
                user.AccountStatus(),
                user.RoleName()
        );
    }

    public List<DUserRoleDto> toDUserRoleListDto(List<IUserRoleDto> users) {
        return users.stream()
                .map(this::toDUserRoleDto)
                .collect(Collectors.toList());
    }

    public List<IUserRoleDto> toIUserRoleListDto(List<DUserRoleDto> users) {
        return users.stream()
                .map(this::toIUserRoleDto)
                .collect(Collectors.toList());
    }

}
