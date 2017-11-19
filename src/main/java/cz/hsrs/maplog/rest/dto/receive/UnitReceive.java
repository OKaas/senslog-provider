package cz.hsrs.maplog.rest.dto.receive;

import javax.validation.constraints.NotNull;

/**
 * Created by OK on 11/19/2017.
 */
public class UnitReceive {

    private Long id;

    @NotNull
    private String description;

    @NotNull
    private Boolean isMobile;

    public UnitReceive() {}

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsMobile() {
        return isMobile;
    }

    public void setIsMobile(Boolean mobile) {
        isMobile = mobile;
    }

    /* --- Commons  --- */
}


