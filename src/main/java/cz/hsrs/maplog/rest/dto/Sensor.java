package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

/**
 * Created by OK on 11/18/2017.
 */
public class Sensor {

    private Long id;
    private String name;
    private String type;

    @JsonBackReference
    private List<Observation> observations;

    @JsonBackReference
    private Phenomenon phenomenon;

    private SensorUnit unit;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public Phenomenon getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(Phenomenon phenomenon) {
        this.phenomenon = phenomenon;
    }

    public SensorUnit getUnit() {
        return unit;
    }

    public void setUnit(SensorUnit unit) {
        this.unit = unit;
    }
    /* --- Commons  --- */
}


