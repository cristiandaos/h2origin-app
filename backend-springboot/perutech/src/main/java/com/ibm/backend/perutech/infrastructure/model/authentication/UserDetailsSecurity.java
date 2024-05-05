package com.ibm.backend.perutech.infrastructure.model.authentication;

//@Component
public class UserDetailsSecurity{// implements UserDetails {
/*
    public final UserRolDto userRolDto;

    @Autowired
    UserDetailsSecurity(UserRolDto userRolDto){
        this.userRolDto = userRolDto;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(userRolDto.getRoleName()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return userRolDto.getPassword();
    }

    @Override
    public String getUsername() {
        return userRolDto.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return userRolDto.getAccountStatus();
    }

    public String getEmail() {
        return userRolDto.getEmail();
    }
*/
}