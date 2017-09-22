package cz.hsrs.maplog.rest.dto.receive;

import java.util.List;

/**
 * DTO for receiving
 * Created by OK on 9/12/2017.
 */
public class Phenomenon {

    private Long id;
    private String name;
    private String unit;
    private List<Sensor> sensors;

    public Phenomenon() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "Phenomenon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", sensors=" + sensors +
                '}';
    }
}


