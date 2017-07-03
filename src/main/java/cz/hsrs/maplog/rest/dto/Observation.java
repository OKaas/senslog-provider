package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by OK on 6/9/2017.
 */
public class Observation {

    private double value;
    private long unitId;
    private long sensorId;
    // TODO: should be defined in properties or system env
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

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

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "ObservationEntity{" +
                "value=" + value +
                ", unitId=" + unitId +
                ", sensorId=" + sensorId +
                ", date=" + date +
                '}';
    }
}


