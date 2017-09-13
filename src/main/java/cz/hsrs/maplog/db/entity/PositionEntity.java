package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the position database table.
 * 
 */
@Entity
@Table(name="position")
@NamedQuery(name="PositionEntity.findAll", query="SELECT p FROM PositionEntity p")
public class PositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private double alt;
	private Timestamp date;
	private Long dop;
	private double lat;
	private double lon;
	private double speed;
	private Long unitId;

	public PositionEntity() {
	}


	@Id
	@SequenceGenerator(name="POSITION_ID_GENERATOR", sequenceName="SEQ_POSITION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="POSITION_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public double getAlt() {
		return this.alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}


	public Date getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}


	public Long getDop() {
		return this.dop;
	}

	public void setDop(Long dop) {
		this.dop = dop;
	}


	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}


	public double getLon() {
		return this.lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}


	public double getSpeed() {
		return this.speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}


	@Column(name="unit_id")
	public Long getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

}