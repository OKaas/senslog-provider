package cz.hsrs.maplog.db.entity;



import javax.persistence.*;
import java.util.Date;

/**
 * Created by OK on 6/12/2017.
 */
@Entity
@Table(name = "position")
@SequenceGenerator(name="seq_position", sequenceName = "seq_position")
public class PositionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_position")
    private Long id;

    private Long unitId;
    private double lat;
    private double lon;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    @Column(nullable = true)
    private double alt;
    @Column(nullable = true)
    private double speed;
    @Column(nullable = true)
    private Long dop;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public Long getDop() {
        return dop;
    }

    public void setDop(Long dop) {
        this.dop = dop;
    }
    /* --- Commons  --- */
}


