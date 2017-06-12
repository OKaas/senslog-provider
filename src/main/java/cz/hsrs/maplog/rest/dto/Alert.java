package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * Created by OK on 6/12/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alert {

    private long alertId;
    private long unitId;
    private Date date;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public long getAlertId() {
        return alertId;
    }

    public void setAlertId(long alertId) {
        this.alertId = alertId;
    }

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

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "Alert{" +
                "alertId=" + alertId +
                ", unitId=" + unitId +
                ", date=" + date +
                '}';
    }
}


