package com.ibm.backend.perutech.infrastructure.repository;

import com.ibm.backend.perutech.infrastructure.model.user.UserEntity;
import com.ibm.backend.perutech.infrastructure.model.user.dto.IUserRoleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Slf4j
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
    public boolean save(UserEntity userEntity) {
        String SQL = "EXEC SP_V1_INS_USER :name, :lastName, :email, :phone, :age, :gender, :password, :recoveryEmail, :district, :countryOrigin, :accountStatus, :roleId, :createdBy";
        String encryptedPassword = (userEntity.getPassword() != null && !userEntity.getPassword().isEmpty()) ? passwordEncoder.encode(userEntity.getPassword()) : "";
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", userEntity.getName())
                .addValue("lastName", userEntity.getLastName())
                .addValue("email", userEntity.getEmail())
                .addValue("phone", userEntity.getPhone())
                .addValue("age", userEntity.getAge())
                .addValue("gender", userEntity.getGender())
                .addValue("password", encryptedPassword)
                .addValue("recoveryEmail", userEntity.getRecoveryEmail())
                .addValue("district", userEntity.getDistrict())
                .addValue("countryOrigin", userEntity.getCountryOrigin())
                .addValue("accountStatus", userEntity.getAccountStatus())
                .addValue("roleId", userEntity.getRoleId())
                .addValue("createdBy", userEntity.getCreatedBy());

        int rowsAffected = namedParameterJdbcTemplate.update(SQL, params);
        log.info("{}",rowsAffected);
        return rowsAffected > 0;
    }

    public List<IUserRoleDto> findAll() {
        String SQL = "SELECT * FROM [View_ListUser]";
        return namedParameterJdbcTemplate.query(SQL, (resultSet, rowNum) -> {
            return new IUserRoleDto(
                    resultSet.getString("Name"),
                    resultSet.getString("LastName"),
                    resultSet.getString("Email"),
                    resultSet.getInt("Phone"),
                    resultSet.getInt("Age"),
                    resultSet.getString("Gender"),
                    resultSet.getString("RecoveryEmail"),
                    resultSet.getString("District"),
                    resultSet.getString("CountryOrigin"),
                    resultSet.getBoolean("AccountStatus"),
                    resultSet.getString("RoleName")
            );
        });
    }

}

