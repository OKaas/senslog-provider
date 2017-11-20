package cz.hsrs.maplog.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the observation database table.
 * 
 */
@Entity
@Table(name="observation")
@NamedQuery(name="ObservationEntity.findAll", query="SELECT o FROM ObservationEntity o")
public class ObservationEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private double observedValue;
	private Timestamp timeReceived;
	private Timestamp timeStamp;
	private SensorEntity sensor;

	public ObservationEntity() {
	}


	@Id
	@SequenceGenerator(name="OBSERVATION_ID_GENERATOR", sequenceName="SEQ_OBSERVATION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OBSERVATION_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
	public SensorEntity getSensor() {
		return this.sensor;
	}

	public void setSensor(SensorEntity sensor) {
		this.sensor = sensor;
	}

}