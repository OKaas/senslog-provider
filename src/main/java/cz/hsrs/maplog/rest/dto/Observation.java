package cz.hsrs.maplog.rest.dto;

import java.sql.Timestamp;

/**
 * Created by OK on 6/9/2017.
 */
public class Observation {

    private Long id;
    private Double value;
    private ObservationSensor sensor;
    private Timestamp timeReceived;
    private Timestamp timeStamp;

    public Observation() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ObservationSensor getSensor() {
        return sensor;
    }

    public void setSensor(ObservationSensor sensor) {
        this.sensor = sensor;
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
        return "Observation{" +
                "id=" + id +
                ", value=" + value +
                ", sensor=" + sensor +
                ", timeReceived=" + timeReceived +
                ", timeStamp=" + timeStamp +
                '}';
    }
}


