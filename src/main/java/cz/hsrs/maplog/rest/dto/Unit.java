package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
public class Unit {

    private Long id;
    private String description;
    private Boolean isMobile;

    @JsonManagedReference
    private List<Sensor> sensors;

    @JsonBackReference
    private List<Position> positions;

    public Unit() {
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

    public Boolean getMobile() {
        return isMobile;
    }

    public void setMobile(Boolean mobile) {
        isMobile = mobile;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isMobile=" + isMobile +
                ", sensors=" + sensors +
                ", positions=" + positions +
                '}';
    }
}


