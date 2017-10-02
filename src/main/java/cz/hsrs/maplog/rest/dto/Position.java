package cz.hsrs.maplog.rest.dto;

import java.sql.Timestamp;

/**
 * Created by OK on 9/22/2017.
 */
public class Position {

    private Long id;
    private double altitude;
    private double dop;
    private double speed;
    private Timestamp timeReceived;
    private Timestamp timeStamp;
    private Unit unit;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getDop() {
        return dop;
    }

    public void setDop(double dop) {
        this.dop = dop;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    /* --- Commons  --- */
}


