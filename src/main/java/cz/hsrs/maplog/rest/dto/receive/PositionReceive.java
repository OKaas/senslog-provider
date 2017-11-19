package cz.hsrs.maplog.rest.dto.receive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * DTO for receiving
 *
 * Created by OK on 9/14/2017.
 */
public class PositionReceive {

    @JsonIgnore
    private Long id;

    @NotNull
    private Long unitId;
    private Timestamp timeStamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double altitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double speed;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long dop;

    public PositionReceive() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Long getDop() {
        return dop;
    }

    public void setDop(Long dop) {
        this.dop = dop;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "PositionReceive{" +
                "unitId=" + unitId +
                ", timeStamp=" + timeStamp +
                ", altitude=" + altitude +
                ", speed=" + speed +
                ", dop=" + dop +
                '}';
    }
}


