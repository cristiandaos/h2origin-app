package com.ibm.backend.perutech.domain.entity.user.dto;

public record DUserRoleDto(
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
