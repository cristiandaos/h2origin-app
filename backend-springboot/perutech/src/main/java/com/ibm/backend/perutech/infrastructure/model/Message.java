package com.ibm.backend.perutech.infrastructure.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enumeración que define mensajes predefinidos para diferentes escenarios.
 *
 * @description: Cada constante de esta enumeración representa un mensaje específico y tiene un campo llamado "message" que contiene el texto del mensaje.
 *
 * @lombok:
 * - @Getter: Genera automáticamente los métodos getter para todos los campos de la enumeración.
 * - @AllArgsConstructor: Genera automáticamente un constructor que inicializa todos los campos de la enumeración.
 */

@Getter
@AllArgsConstructor
public enum Message {
    ERROR_SERVER("An error occurred on the server. Please try again later"),
    INVALID_LOGIN("Incorrect email or password"),
    SUCCESS_LOGIN("Authentication successful"),
    FAIL("could not register"),
    SUCCESS("registers correctly"),
    SUCCESS_LIST("The list was successfully obtained"),
    EMPTY_LIST("The list is empty"),
    INVALID_TOKEN("Invalid token JWT!"),
    HTTP_STATUS_401("401 Unauthorized"),
    HTTP_STATUS_200("200");

    private final String message;
}
