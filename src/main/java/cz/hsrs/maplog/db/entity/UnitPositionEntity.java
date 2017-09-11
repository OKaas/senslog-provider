package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the units_position database table.
 * 
 */
@Entity
@Table(name="unit_position")
@NamedQuery(name="UnitPositionEntity.findAll", query="SELECT u FROM UnitPositionEntity u")
public class UnitPositionEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private double altitude;
	private double dop;
	private Timestamp firstTimeStamp;
	private double speed;
	private Timestamp timeReceived;
	private Timestamp timeStamp;
	private List<ObservationEntity> observations;
	private UnitEntity unit;

	public UnitPositionEntity() {
	}


	@Id
	@SequenceGenerator(name="UNITS_POSITION_GID_GENERATOR", sequenceName="SEQ_UNITS_POSITION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNITS_POSITION_GID_GENERATOR")
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
	public UnitEntity getUnit() {
		return this.unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}

}