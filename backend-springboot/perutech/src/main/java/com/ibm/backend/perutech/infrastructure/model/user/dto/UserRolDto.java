package com.ibm.backend.perutech.infrastructure.model.user.dto;

import lombok.Data;

@Data
public class UserRolDto{
        private String Email;
        private String Password;
        private Boolean AccountStatus;
        private String RoleName;
}
