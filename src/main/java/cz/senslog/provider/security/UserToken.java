package cz.senslog.provider.security;

import cz.senslog.model.db.PrivilegeGroupEntity;
import cz.senslog.model.db.User2UnitGroupEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by OK on 11/17/2017.
 */
public class UserToken implements UserDetails {

    public String username;
    public String password;

    public Map<User2UnitGroupEntity, List<PrivilegeGroupEntity>> privileges;

    public UserToken() {}

    public UserToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
        return true;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "UserToken{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


