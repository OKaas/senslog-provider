package cz.hsrs.maplog.rest.dto.receive;

import java.util.List;

/**
 * DTO for receiving
 * Created by OK on 9/12/2017.
 */
public class PhenomenonReceive {

    private Long id;
    private String name;
    private String unit;
    private List<SensorReceive> sensorReceives;

    public PhenomenonReceive() {
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

    public List<SensorReceive> getSensorReceives() {
        return sensorReceives;
    }

    public void setSensorReceives(List<SensorReceive> sensorReceives) {
        this.sensorReceives = sensorReceives;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "PhenomenonReceive{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", sensorReceives=" + sensorReceives +
                '}';
    }
}


