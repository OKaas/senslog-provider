package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroup {

    private Integer id;
    private Boolean hasChildren;
    private String name;
    private List<User> users;
    // all child groups
    private List<UserGroup> userGroups;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    /* --- Commons  --- */
}


