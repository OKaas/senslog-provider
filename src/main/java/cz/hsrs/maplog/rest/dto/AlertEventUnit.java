package cz.hsrs.maplog.rest.dto;

/**
 * Created by OK on 1/21/2018.
 */
public class AlertEventUnit {

    private Long id;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "AlertEventUnit{" +
                "id=" + id +
                '}';
    }
}


