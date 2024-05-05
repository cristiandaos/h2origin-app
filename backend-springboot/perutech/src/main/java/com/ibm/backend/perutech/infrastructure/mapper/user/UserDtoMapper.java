package com.ibm.backend.perutech.infrastructure.mapper.user;

import com.ibm.backend.perutech.domain.entity.User;
import com.ibm.backend.perutech.infrastructure.model.user.dto.CreateUserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoMapper {
    public CreateUserResponseDto toResponseObj(User user) {
        return new CreateUserResponseDto(
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
                user.RoleId()
        );
    }
}
