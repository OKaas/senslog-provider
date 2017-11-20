package cz.hsrs.maplog.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sensor database table.
 * 
 */
@Entity
@Table(name="sensor")
@NamedQuery(name="SensorEntity.findAll", query="SELECT s FROM SensorEntity s")
public class SensorEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String type;
	private List<ObservationEntity> observations;
	private PhenomenonEntity phenomenon;
	private UnitEntity unit;

	public SensorEntity() {
	}


	@Id
	@SequenceGenerator(name="SENSOR_ID_GENERATOR", sequenceName="SEQ_SENSOR")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SENSOR_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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
	public PhenomenonEntity getPhenomenon() {
		return this.phenomenon;
	}

	public void setPhenomenon(PhenomenonEntity phenomenon) {
		this.phenomenon = phenomenon;
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