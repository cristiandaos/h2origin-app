package com.ibm.backend.perutech.infrastructure.Repository;

import com.ibm.backend.perutech.infrastructure.model.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, PasswordEncoder passwordEncoder) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Este método guarda un objeto UserEntity en la base de datos y devuelve el mismo objeto con posibles modificaciones realizadas durante el proceso de guardado.
     *
     * @param userEntity El objeto UserEntity que se va a guardar en la base de datos.
     * @return El objeto UserEntity después de guardar en la base de datos (puede contener cambios realizados durante el proceso de guardado).
     *
     * @description: Este método utiliza una consulta SQL parametrizada para llamar a un procedimiento almacenado (SP_SAVE_USER) que guarda los detalles del usuario en la base de datos.
     * Los detalles del usuario se proporcionan como parámetros en la consulta SQL.
     * Antes de pasar la contraseña del usuario a la consulta SQL, se comprueba si está presente y se cifra utilizando un codificador de contraseñas (passwordEncoder) para mayor seguridad.
     * Después de ejecutar la consulta SQL, el método utiliza un objeto NamedParameterJdbcTemplate para mapear los resultados de la consulta a un objeto UserEntity y lo devuelve.
     */
    @Transactional
    public UserEntity save(UserEntity userEntity) {
        String SQL = "EXEC SP_SAVE_USER :name, :lastName, :email, :phone, :age, :gender, :encryptedPassword, :recoveryEmail, :district, :countryOrigin, :accountStatus, :roleId, :createdBy, :creationDate";
        String encryptedPassword = "";
        if (userEntity.getPassword() != null && !userEntity.getPassword().isEmpty()) {
            encryptedPassword = passwordEncoder.encode(userEntity.getPassword());
        }
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", userEntity.getName())
                .addValue("lastName", userEntity.getLastName())
                .addValue("email", userEntity.getEmail())
                .addValue("phone", userEntity.getPhone())
                .addValue("age", userEntity.getAge())
                .addValue("gender", userEntity.getGender())
                .addValue("encryptedPassword", encryptedPassword)
                .addValue("recoveryEmail", userEntity.getRecoveryEmail())
                .addValue("district", userEntity.getDistrict())
                .addValue("countryOrigin", userEntity.getCountryOrigin())
                .addValue("accountStatus", userEntity.getAccountStatus())
                .addValue("roleId", userEntity.getRoleId())
                .addValue("createdBy", userEntity.getCreatedBy())
                .addValue("creationDate", userEntity.getCreationDate());
        return namedParameterJdbcTemplate.queryForObject(SQL, params, new BeanPropertyRowMapper<>(UserEntity.class));
    }


}

