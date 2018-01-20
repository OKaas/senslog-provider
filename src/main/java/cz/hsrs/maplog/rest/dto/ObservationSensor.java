package cz.hsrs.maplog.rest.dto;

/**
 * Created by OK on 1/20/2018.
 */
public class ObservationSensor {

    private Long id;
    private ObservationUnit unit;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObservationUnit getUnit() {
        return unit;
    }

    public void setUnit(ObservationUnit unit) {
        this.unit = unit;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "ObservationSensor{" +
                "id=" + id +
                '}';
    }
}


