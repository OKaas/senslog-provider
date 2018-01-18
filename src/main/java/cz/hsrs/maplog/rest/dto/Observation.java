package cz.hsrs.maplog.rest.dto;

import java.sql.Timestamp;

/**
 * Created by OK on 6/9/2017.
 */
public class Observation {

    private Long id;
    private Double observedValue;
    private long unitId;
    private long sensorId;
    // TODO: should be defined in properties or system env
    private Timestamp timeReceived;

    private Sensor sensor;
    private Unit unit;
    private Position position;

    public Observation() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Double getValue() {
        return observedValue;
    }

    public void setValue(double value) {
        this.observedValue = value;
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
        return timeReceived;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timeReceived = timestamp;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "ObservationEntity{" +
                "value=" + observedValue +
                ", unitId=" + unitId +
                ", sensorId=" + sensorId +
                ", timestamp=" + timeReceived +
                '}';
    }
}


