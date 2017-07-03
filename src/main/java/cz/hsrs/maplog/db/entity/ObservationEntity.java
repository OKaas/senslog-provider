package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the observations database table.
 * 
 */
@Entity
@Table(name="observations")
@NamedQuery(name="ObservationEntity.findAll", query="SELECT o FROM ObservationEntity o")
public class ObservationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer observationId;
	private double observedValue;
	private Timestamp timeReceived;
	private Timestamp timeStamp;
	private SensorEntity sensor;
	private UnitEntity unit;
	private UnitsPositionEntity unitsPosition;

	public ObservationEntity() {
	}


	@Id
	@SequenceGenerator(name="OBSERVATIONS_OBSERVATIONID_GENERATOR", sequenceName="SEQ_OBSERVATIONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBSERVATIONS_OBSERVATIONID_GENERATOR")
	@Column(name="observation_id")
	public Integer getObservationId() {
		return this.observationId;
	}

	public void setObservationId(Integer observationId) {
		this.observationId = observationId;
	}


	@Column(name="observed_value")
	public double getObservedValue() {
		return this.observedValue;
	}

	public void setObservedValue(double observedValue) {
		this.observedValue = observedValue;
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


	//bi-directional many-to-one association to SensorEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sensor_id")
	public SensorEntity getSensor() {
		return this.sensor;
	}

	public void setSensor(SensorEntity sensor) {
		this.sensor = sensor;
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


	//bi-directional many-to-one association to UnitsPositionEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="gid")
	public UnitsPositionEntity getUnitsPosition() {
		return this.unitsPosition;
	}

	public void setUnitsPosition(UnitsPositionEntity unitsPosition) {
		this.unitsPosition = unitsPosition;
	}

}