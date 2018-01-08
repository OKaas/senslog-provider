package cz.hsrs.maplog.security;

import cz.hsrs.maplog.db.model.UserGroupEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Created by OK on 11/17/2017.
 */
public class UserToken implements UserDetails {

    public String username;
    public String password;

    public Set<Long> group;
    public Collection<? extends GrantedAuthority> authorities;

    public UserGroupEntity userGroupEntity;

    public UserToken() {}

    public UserToken(String username, String password, UserGroupEntity userGroupEntity, Set<Long> group, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.group = group;
        this.userGroupEntity = userGroupEntity;
        this.authorities = authorities;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Long> getGroup() {
        return group;
    }

    public void setGroup(Set<Long> group) {
        this.group = group;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public UserGroupEntity getUserGroupEntity() {
        return userGroupEntity;
    }

    public void setUserGroupEntity(UserGroupEntity userGroupEntity) {
        this.userGroupEntity = userGroupEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
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
                ", group=" + group +
                ", authorities=" + authorities.toString() +
                ", userGroupEntity=" + userGroupEntity.toString() +
                '}';
    }
}


