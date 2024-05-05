package com.ibm.backend.perutech.infrastructure.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class UserEntity {
    private Long UserId;
    private String Name;
    private String LastName;
    private String Email;
    private Integer Phone;
    private Integer Age;
    private Character Gender;
    private String Password;
    private String RecoveryEmail;
    private String District;
    private String CountryOrigin;
    private Boolean AccountStatus;
    private Integer RoleId;
    private String CreatedBy;
    private LocalDateTime CreationDate;
    private String UpdatedBy;
    private LocalDateTime UpdateDate;
    private String DeletedBy;
    private LocalDateTime DeletionDate;
}
