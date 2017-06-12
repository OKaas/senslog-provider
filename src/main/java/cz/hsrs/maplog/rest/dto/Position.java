package cz.hsrs.maplog.rest.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by OK on 6/9/2017.
 */
public class Position {

    private double lat;
    private double lon;
    private long unitId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double alt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private double speed;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long dop;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        this.alt = alt;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public long getDop() {
        return dop;
    }

    public void setDop(int dop) {
        this.dop = dop;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "Position{" +
                "unitId=" + unitId +
                ", date=" + date +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}


