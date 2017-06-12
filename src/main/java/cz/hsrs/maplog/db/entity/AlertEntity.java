package cz.hsrs.maplog.db.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by OK on 6/12/2017.
 */
@Entity
@Table(name = "alert")
@SequenceGenerator(name="seq_alert", sequenceName = "seq_alert")
public class AlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_alert")
    private Long id;

    private Long unitId;
    private Long alertId;
    private Date date;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAlertId() {
        return alertId;
    }

    public void setAlertId(Long alertId) {
        this.alertId = alertId;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /* --- Commons  --- */
}


