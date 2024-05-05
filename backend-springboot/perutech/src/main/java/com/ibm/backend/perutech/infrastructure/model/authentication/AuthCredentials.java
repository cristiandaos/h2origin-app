package com.ibm.backend.perutech.infrastructure.model.authentication;

import lombok.Data;

@Data
public class AuthCredentials {
    private String username;
    private String password;
}