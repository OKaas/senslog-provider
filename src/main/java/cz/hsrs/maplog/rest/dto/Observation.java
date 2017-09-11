package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;


/**
 * Created by OK on 6/9/2017.
 */
public class Observation {

    private double value;
    private long unitId;
    private long sensorId;
    // TODO: should be defined in properties or system env
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;

    public Observation() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unit) {
        this.unitId = unit;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "ObservationEntity{" +
                "value=" + value +
                ", unitId=" + unitId +
                ", sensorId=" + sensorId +
                ", timestamp=" + timestamp +
                '}';
    }
}


