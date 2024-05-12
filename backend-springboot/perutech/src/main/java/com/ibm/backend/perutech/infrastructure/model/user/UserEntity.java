package com.ibm.backend.perutech.infrastructure.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty
    private Long UserId;

    @JsonProperty
    private String Name;

    @JsonProperty
    private String LastName;

    @JsonProperty
    private String Email;

    @JsonProperty
    private Integer Phone;

    @JsonProperty
    private Integer Age;

    @JsonProperty
    private String Gender;

    @JsonProperty
    private String Password;

    @JsonProperty
    private String RecoveryEmail;

    @JsonProperty
    private String District;

    @JsonProperty
    private String CountryOrigin;

    @JsonProperty
    private Boolean AccountStatus;

    @JsonProperty
    private Integer RoleId;

    @JsonProperty
    private String CreatedBy;

    private LocalDateTime CreationDate;

    @JsonProperty
    private String UpdatedBy;

    private LocalDateTime UpdateDate;

    @JsonProperty
    private String DeletedBy;

    private LocalDateTime DeletionDate;

}
