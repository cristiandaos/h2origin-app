package com.ibm.backend.perutech.infrastructure.model.user.dto;

public record CreateUserResponseDto(
        String Name,
        String lastName,
        String email,
        Integer phone,
        Integer age,
        Character gender,
        String recoveryEmail,
        String district,
        String countryOrigin,
        Boolean accountStatus,
        Integer roleId)
{ }
