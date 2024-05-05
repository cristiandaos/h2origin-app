package com.ibm.backend.perutech.domain.entity;

import java.time.LocalDateTime;


public record User(
        Long UserId,
        String Name,
        String LastName,
        String Email,
        Integer Phone,
        Integer Age,
        Character Gender,
        String Password,
        String RecoveryEmail,
        String District,
        String CountryOrigin,
        Boolean AccountStatus,
        Integer RoleId,
        String CreatedBy,
        LocalDateTime CreationDate,
        String UpdatedBy,
        LocalDateTime UpdateDate,
        String DeletedBy,
        LocalDateTime DeletionDate) {
}
