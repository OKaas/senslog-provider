package cz.hsrs.maplog.rest.dto;

import java.sql.Timestamp;

/**
 * Created by OK on 7/4/2017.
 */
public class AlertEvent {

    private Integer id;

    private Integer gid;
    private Timestamp timeStamp;

    private AlertEventAlert alertEventAlert;
    private AlertEventUnit alertEventUnit;
    private AlertEventEnumItem alertEventEnumItem;

    public AlertEvent() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public AlertEventAlert getAlertEventAlert() {
        return alertEventAlert;
    }

    public void setAlertEventAlert(AlertEventAlert alertEventAlert) {
        this.alertEventAlert = alertEventAlert;
    }

    public AlertEventUnit getAlertEventUnit() {
        return alertEventUnit;
    }

    public void setAlertEventUnit(AlertEventUnit alertEventUnit) {
        this.alertEventUnit = alertEventUnit;
    }

    public AlertEventEnumItem getAlertEventEnumItem() {
        return alertEventEnumItem;
    }

    public void setAlertEventEnumItem(AlertEventEnumItem alertEventEnumItem) {
        this.alertEventEnumItem = alertEventEnumItem;
    }
    /* --- Commons  --- */

    @Override
    public String toString() {
        return "AlertEvent{" +
                "id=" + id +
                ", gid=" + gid +
                ", timeStamp=" + timeStamp +
                ", alertEventAlert=" + alertEventAlert +
                ", alertEventUnit=" + alertEventUnit +
                ", alertEventEnumItem=" + alertEventEnumItem +
                '}';
    }
}


