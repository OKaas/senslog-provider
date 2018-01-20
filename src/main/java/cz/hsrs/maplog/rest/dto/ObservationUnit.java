package cz.hsrs.maplog.rest.dto;

/**
 * Created by OK on 1/20/2018.
 */
public class ObservationUnit {

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
        return "ObservationUnit{" +
                "id=" + id +
                '}';
    }
}


