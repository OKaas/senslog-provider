package cz.hsrs.maplog.rest.dto.receive;

/**
 * Created by OK on 8/4/2017.
 */
public class SensorReceive {

    private Long id;

    public SensorReceive() {
    }

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
        return "SensorReceive{" +
                "id=" + id +
                '}';
    }
}


