package cz.hsrs.maplog.rest.dto.receive;

import javax.validation.constraints.NotNull;

/**
 * Created by OK on 1/21/2018.
 */
public class AlertReceive {

    private Long id;
    @NotNull
    private String description;

    public AlertReceive() {
    }

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

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "AlertReceive{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}


