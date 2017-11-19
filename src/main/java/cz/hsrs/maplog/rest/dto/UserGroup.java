package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
public class UserGroup {

    @Id
    @NotNull
    private Long id;

    @NotNull
    private String name;

    @JsonManagedReference private List<UserGroup> userGroups;

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

    public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}


