package cz.hsrs.maplog.rest.dto.receive;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.sql.Timestamp;

/**
 * DTO for receiving
 *
 * Created by OK on 9/14/2017.
 */
public class Position {

    private Long unit;
    private Timestamp timeStamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double altitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double speed;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long dop;

    public Position() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
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
        return "Position{" +
                "unit=" + unit +
                ", timeStamp=" + timeStamp +
                ", altitude=" + altitude +
                ", speed=" + speed +
                ", dop=" + dop +
                '}';
    }
}


