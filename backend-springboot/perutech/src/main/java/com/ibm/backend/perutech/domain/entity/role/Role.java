package com.ibm.backend.perutech.domain.entity.role;

import java.time.LocalDateTime;

public record Role(
        Long roleId,
        String roleKey,
        String roleName,
        String createdBy,
        LocalDateTime creationDate,
        String updatedBy,
        LocalDateTime updateDate,
        String deletedBy,
        LocalDateTime deletionDate
) {
}