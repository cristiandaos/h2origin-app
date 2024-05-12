package com.ibm.backend.perutech.infrastructure.model.user.dto;

public record IUserRoleDto(
        String Name,
        String LastName,
        String Email,
        Integer Phone,
        Integer Age,
        String Gender,
        String RecoveryEmail,
        String District,
        String CountryOrigin,
        Boolean AccountStatus,
        String RoleName)
{ }
