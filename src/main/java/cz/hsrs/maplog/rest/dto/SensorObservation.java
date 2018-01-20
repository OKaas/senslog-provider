package cz.hsrs.maplog.rest.dto;

import java.sql.Timestamp;

/**
 * Created by OK on 1/20/2018.
 */
public class SensorObservation {

    private Long id;
    private Double observedValue;
    private Timestamp timeReceived;
    private Timestamp timeStamp;

    public SensorObservation() {}

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getObservedValue() {
        return observedValue;
    }

    public void setObservedValue(Double observedValue) {
        this.observedValue = observedValue;
    }

    public Timestamp getTimeReceived() {
        return timeReceived;
    }

    public void setTimeReceived(Timestamp timeReceived) {
        this.timeReceived = timeReceived;
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
        return "SensorObservation{" +
                "id=" + id +
                ", observedValue=" + observedValue +
                ", timeReceived=" + timeReceived +
                ", timeStamp=" + timeStamp +
                '}';
    }
}


