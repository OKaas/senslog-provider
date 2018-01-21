package cz.hsrs.maplog.rest.dto.receive;

import java.sql.Timestamp;

/**
 * Created by OK on 1/21/2018.
 */
public class AlertEventReceive {

    private Long id;
    private Timestamp timeStamp;
    private Long alert;
    private Long unit;

    public AlertEventReceive() {
    }
    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Long getAlert() {
        return alert;
    }

    public void setAlert(Long alert) {
        this.alert = alert;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(Long unit) {
        this.unit = unit;
    }
    /* --- Commons  --- */

    @Override
    public String toString() {
        return "AlertEventReceive{" +
                "id=" + id +
                ", timeStamp=" + timeStamp +
                ", alert=" + alert +
                ", unit=" + unit +
                '}';
    }
}


