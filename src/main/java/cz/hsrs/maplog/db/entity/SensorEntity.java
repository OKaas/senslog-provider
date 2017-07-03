package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sensors database table.
 * 
 */
@Entity
@Table(name="sensors")
@NamedQuery(name="SensorEntity.findAll", query="SELECT s FROM SensorEntity s")
public class SensorEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long sensorId;
	private String sensorName;
	private String sensorType;
	private List<ObservationEntity> observations;
	private PhenomenonEntity phenomenon;

	public SensorEntity() {
	}


	@Id
	@SequenceGenerator(name="SENSORS_SENSORID_GENERATOR", sequenceName="SEQ_SENSORS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SENSORS_SENSORID_GENERATOR")
	@Column(name="sensor_id")
	public Long getSensorId() {
		return this.sensorId;
	}

	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}


	@Column(name="sensor_name")
	public String getSensorName() {
		return this.sensorName;
	}

	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}


	@Column(name="sensor_type")
	public String getSensorType() {
		return this.sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}


	//bi-directional many-to-one association to ObservationEntity
	@OneToMany(mappedBy="sensor")
	public List<ObservationEntity> getObservations() {
		return this.observations;
	}

	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}

	public ObservationEntity addObservation(ObservationEntity observation) {
		getObservations().add(observation);
		observation.setSensor(this);

		return observation;
	}

	public ObservationEntity removeObservation(ObservationEntity observation) {
		getObservations().remove(observation);
		observation.setSensor(null);

		return observation;
	}


	//bi-directional many-to-one association to PhenomenonEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="phenomenon_id")
	public PhenomenonEntity getPhenomenon() {
		return this.phenomenon;
	}

	public void setPhenomenon(PhenomenonEntity phenomenon) {
		this.phenomenon = phenomenon;
	}

}