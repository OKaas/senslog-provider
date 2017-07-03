package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the units_positions database table.
 * 
 */
@Entity
@Table(name="units_positions")
@NamedQuery(name="UnitsPositionEntity.findAll", query="SELECT u FROM UnitsPositionEntity u")
public class UnitsPositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer gid;
	private double altitude;
	private double dop;
	private Timestamp firstTimeStamp;
	private double speed;
	private Timestamp timeReceived;
	private Timestamp timeStamp;
	private List<ObservationEntity> observations;
	private UnitEntity unit;

	public UnitsPositionEntity() {
	}


	@Id
	@SequenceGenerator(name="UNITS_POSITIONS_GID_GENERATOR", sequenceName="SEQ_UNITS_POSITIONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNITS_POSITIONS_GID_GENERATOR")
	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
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


	@Column(name="first_time_stamp")
	public Timestamp getFirstTimeStamp() {
		return this.firstTimeStamp;
	}

	public void setFirstTimeStamp(Timestamp firstTimeStamp) {
		this.firstTimeStamp = firstTimeStamp;
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


	//bi-directional many-to-one association to ObservationEntity
	@OneToMany(mappedBy="unitsPosition")
	public List<ObservationEntity> getObservations() {
		return this.observations;
	}

	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}

	public ObservationEntity addObservation(ObservationEntity observation) {
		getObservations().add(observation);
		observation.setUnitsPosition(this);

		return observation;
	}

	public ObservationEntity removeObservation(ObservationEntity observation) {
		getObservations().remove(observation);
		observation.setUnitsPosition(null);

		return observation;
	}


	//bi-directional many-to-one association to UnitEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unit_id")
	public UnitEntity getUnit() {
		return this.unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}

}