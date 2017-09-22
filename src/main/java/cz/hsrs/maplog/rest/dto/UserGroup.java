package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import cz.hsrs.maplog.db.entity.UnitToGroupEntity;
import cz.hsrs.maplog.db.entity.UserEntity;
import cz.hsrs.maplog.db.entity.UserGroupEntity;

import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroup {

    private Long id;
    private String name;
    private List<UnitToGroupEntity> unitToGroups;
    private List<UserEntity> users;
    @JsonBackReference
    private UserGroupEntity userGroup;
    @JsonManagedReference
    private List<UserGroupEntity> userGroups;

    /* --- Collaborates --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UnitToGroupEntity> getUnitToGroups() {
        return unitToGroups;
    }

    public void setUnitToGroups(List<UnitToGroupEntity> unitToGroups) {
        this.unitToGroups = unitToGroups;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public UserGroupEntity getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroupEntity userGroup) {
        this.userGroup = userGroup;
    }

    public List<UserGroupEntity> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroupEntity> userGroups) {
        this.userGroups = userGroups;
    }

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}


