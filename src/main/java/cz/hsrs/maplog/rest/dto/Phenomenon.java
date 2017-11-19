package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * Created by OK on 11/18/2017.
 */
public class Phenomenon {

    private Long id;
    private String name;
    private String unitDesc;

    @JsonManagedReference
    private List<Sensor> sensors;

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

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }
    /* --- Commons  --- */
}


