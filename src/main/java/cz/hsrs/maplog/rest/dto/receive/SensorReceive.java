package cz.hsrs.maplog.rest.dto.receive;

import javax.validation.constraints.NotNull;

/**
 * Created by OK on 8/4/2017.
 */
public class SensorReceive {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    private Long unitId;
    private Long phenomenonId;

    public SensorReceive() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getPhenomenonId() {
        return phenomenonId;
    }

    public void setPhenomenonId(Long phenomenonId) {
        this.phenomenonId = phenomenonId;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "SensorReceive{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", unitId=" + unitId +
                ", phenomenonId=" + phenomenonId +
                '}';
    }
}


