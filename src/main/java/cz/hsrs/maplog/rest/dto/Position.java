package cz.hsrs.maplog.rest.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by OK on 6/9/2017.
 */
public class Position {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    private Double lat;
    private Double lon;
    private Long unitId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp date;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double alt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double speed;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long dop;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unitId) {
        this.unitId = unitId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

    public Double getAlt() {
        return alt;
    }

    public void setAlt(double alt) {
        this.alt = alt;
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


