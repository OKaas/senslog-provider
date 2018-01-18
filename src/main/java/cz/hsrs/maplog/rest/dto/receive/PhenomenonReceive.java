package cz.hsrs.maplog.rest.dto.receive;

import java.util.List;

/**
 * DTO for receiving
 * Created by OK on 9/12/2017.
 */
public class PhenomenonReceive {

    private Long id;
    private String unitDesc;
    private String name;
    private List<Long> sensors;

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

    public String getUnitDesc() {
        return unitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        this.unitDesc = unitDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSensors() {
        return sensors;
    }

    public void setSensors(List<Long> sensors) {
        this.sensors = sensors;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "PhenomenonReceive{" +
                "id=" + id +
                ", username='" + unitDesc + '\'' +
                ", sensors=" + sensors +
                '}';
    }
}


