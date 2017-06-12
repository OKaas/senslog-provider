package cz.hsrs.maplog.db.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by OK on 6/9/2017.
 */
@Entity
@Table(name = "observation")
@SequenceGenerator(name="seq_observation", sequenceName = "seq_observation")
public class ObservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_observation")
    private Long id;

    private Long unitId;
    private double value;
    private Long sensorId;
    private Date date;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    /* --- Commons  --- */
}


