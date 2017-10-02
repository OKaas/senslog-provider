package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Created by OK on 9/22/2017.
 */
public class UnitToGroup {

    private Long id;

    @JsonBackReference
    private Unit unit;
    @JsonBackReference
    private UserGroup userGroup;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }
    /* --- Commons  --- */
}


