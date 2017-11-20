package cz.hsrs.maplog.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


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
	private double altitude;
	private double dop;
	private double speed;
	private Timestamp timeReceived;
	private Timestamp timeStamp;
	private UnitEntity unit;

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


	public double getAltitude() {
		return this.altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}


	public double getDop() {
		return this.dop;
	}

	public void setDop(double dop) {
		this.dop = dop;
	}


	public double getSpeed() {
		return this.speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}


	@Column(name="time_received")
	public Timestamp getTimeReceived() {
		return this.timeReceived;
	}

	public void setTimeReceived(Timestamp timeReceived) {
		this.timeReceived = timeReceived;
	}


	@Column(name="time_stamp")
	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	//bi-directional many-to-one association to UnitEntity
	@ManyToOne(fetch=FetchType.LAZY)
	public UnitEntity getUnit() {
		return this.unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}

}