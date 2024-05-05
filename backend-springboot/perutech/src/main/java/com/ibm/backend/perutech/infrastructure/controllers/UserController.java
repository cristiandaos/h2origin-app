package com.ibm.backend.perutech.infrastructure.controllers;

import com.ibm.backend.perutech.application.usecases.CreateUserInteractor;
import com.ibm.backend.perutech.domain.entity.User;
import com.ibm.backend.perutech.infrastructure.mapper.user.UserDtoMapper;
import com.ibm.backend.perutech.infrastructure.mapper.user.UserEntityMapper;
import com.ibm.backend.perutech.infrastructure.model.Message;
import com.ibm.backend.perutech.infrastructure.model.ServiceResponseModel;
import com.ibm.backend.perutech.infrastructure.model.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final CreateUserInteractor createUserUseCase;
    private final UserEntityMapper userEntityMapper;
    private final UserDtoMapper userDtoMapper;

    @Autowired
    public UserController(CreateUserInteractor createUserUseCase, UserEntityMapper userEntityMapper, UserDtoMapper userDtoMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userEntityMapper = userEntityMapper;
        this.userDtoMapper = userDtoMapper;
    }

    /**
     * Este método maneja una solicitud HTTP POST para crear un nuevo usuario en el sistema.
     *
     * @param request El objeto UserEntity que contiene los datos del usuario a crear, proporcionado en el cuerpo de la solicitud.
     * @return Un objeto ResponseEntity que contiene una respuesta con un ServiceResponseModel, que incluye el resultado de la operación de creación del usuario.
     *
     * @description: Este método utiliza la anotación @PostMapping para mapear la ruta "/create" a este método, lo que significa que se activará cuando se realice una solicitud POST a esa ruta.
     * El parámetro @RequestBody indica que el cuerpo de la solicitud HTTP se convertirá automáticamente en un objeto UserEntity y se pasará como argumento al método.
     * El método crea un ServiceResponseModel para encapsular la respuesta de la operación de creación del usuario.
     * Se utiliza un bloque try-catch para manejar cualquier excepción que pueda ocurrir durante la creación del usuario.
     * Si la creación del usuario tiene éxito, se establecen los campos del ServiceResponseModel correspondientes y se devuelve una respuesta HTTP 201 (CREATED) con los datos del usuario creado.
     * Si la creación del usuario falla por alguna razón, se establece un mensaje de error en el ServiceResponseModel y se devuelve una respuesta HTTP 500 (INTERNAL_SERVER_ERROR).
     */
    @PostMapping("/create")
    ResponseEntity<ServiceResponseModel> create(@RequestBody UserEntity request) {
        ServiceResponseModel serviceResponse = new ServiceResponseModel();
        try {
            User user = createUserUseCase.createUser(userEntityMapper.toDomainObj(request));
            if (user != null) {
                serviceResponse.setRecords(true);
                serviceResponse.setMessage(Message.SUCCESS.getMessage());
                serviceResponse.setDataModel(userDtoMapper.toResponseObj(user));
            } else {
                serviceResponse.setRecords(false);
                serviceResponse.setMessage(Message.FAIL.getMessage());
            }
            serviceResponse.setSuccess(true);
            return new ResponseEntity<>(serviceResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            serviceResponse.setSuccess(false);
            serviceResponse.setMessage(Message.ERROR_SERVER.getMessage());
            return new ResponseEntity<>(serviceResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
