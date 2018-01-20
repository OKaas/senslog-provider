package cz.hsrs.maplog.rest.dto.receive;

import java.sql.Timestamp;

/**
 * Created by OK on 1/20/2018.
 */
public class ObservationReceive {

    private Long sensor;

    // TODO: here should not be unit id, because IoT dont care about unit, it want to just send data
    private Long unitId;

    private Double observedValue;
    private Timestamp timeStamp;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getSensor() {
        return sensor;
    }

    public void setSensor(Long sensor) {
        this.sensor = sensor;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Double getObservedValue() {
        return observedValue;
    }

    public void setObservedValue(Double observedValue) {
        this.observedValue = observedValue;
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
        return "ObservationReceive{" +
                "sensor=" + sensor +
                ", unitId=" + unitId +
                ", observedValue=" + observedValue +
                ", timeStamp=" + timeStamp +
                '}';
    }
}


