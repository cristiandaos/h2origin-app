package com.ibm.backend.perutech.infrastructure.security;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthDetailsService implements UserDetailsService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public AuthDetailsService(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    /**
     * Este método carga los detalles de un usuario utilizando su dirección de correo electrónico como identificador único.
     *
     * @param email La dirección de correo electrónico del usuario.
     * @return UserDetails que representa los detalles del usuario cargado.
     * @throws UsernameNotFoundException si no se puede encontrar un usuario con la dirección de correo electrónico proporcionada.
     *
     * @description: En este método, se ejecuta una consulta SQL para obtener los detalles del usuario desde la base de datos utilizando su dirección de correo electrónico como filtro.
     * Los detalles del usuario se mapean a un objeto UserRolDto utilizando un objeto NamedParameterJdbcTemplate.
     * Si no se encuentra ningún usuario con la dirección de correo electrónico proporcionada, se lanza una excepción UsernameNotFoundException.
     * Si se encuentra el usuario, se construye un objeto UserDetails utilizando los detalles obtenidos y se devuelve.
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String SQL = "SELECT * from [View_LoadUser] WHERE Email = :email";
        MapSqlParameterSource params = new MapSqlParameterSource().addValue("email", email);
        UserRolDto userRolDto = namedParameterJdbcTemplate.queryForObject(SQL, params, new BeanPropertyRowMapper<>(UserRolDto.class));
        if (userRolDto == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRolDto.getRoleName()));
        return new User(
                userRolDto.getEmail(),
                userRolDto.getPassword(),
                userRolDto.getAccountStatus(),
                true,
                true,
                true,
                authorities
        );
    }

    @Data
    protected static class UserRolDto{
        private String Email;
        private String Password;
        private Boolean AccountStatus;
        private String RoleName;
    }
}
