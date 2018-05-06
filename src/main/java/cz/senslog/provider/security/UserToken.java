package cz.senslog.provider.security;

import cz.senslog.model.db.PrivilegeGroupEntity;
import cz.senslog.model.db.UnitEntity;
import cz.senslog.model.db.User2UnitGroupEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * Created by OK on 11/17/2017.
 */
public class UserToken implements UserDetails {

    private final String username;
    private final String password;

    /***
     *
     */
    public Map<User2UnitGroupEntity, List<PrivilegeGroupEntity>> privileges;

    /***
     * TODO: It should be here but for PoC
     */
    public Set<Long> unitGroupId;

    public UserToken(@NotNull String username, @NotNull String password, @NotNull  List<User2UnitGroupEntity> user2UnitGroupEntities) {
        this.username = username;
        this.password = password;

        this.privileges = new HashMap<>();
        this.unitGroupId = new HashSet<>();

        // initialize internal Unit <-> privilege map
        for( User2UnitGroupEntity value: user2UnitGroupEntities ){

            privileges.put(value, value.getPrivilegeGroups());

            // c'mon streams :/
            for(UnitEntity entity : value.getUnitGroup().getUnits()){
                unitGroupId.add(entity.getId());
            }
        }
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Set<Long> getUnitGroup(){
        return unitGroupId;
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
                ", privileges=" + privileges +
                ", unitGroupId=" + unitGroupId +
                '}';
    }
}


