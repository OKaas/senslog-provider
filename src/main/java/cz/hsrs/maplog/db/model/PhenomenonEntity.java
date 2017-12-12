package cz.hsrs.maplog.db.model;

import cz.hsrs.maplog.db.queryspecification.EntityQueryable;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the phenomenon database table.
 * 
 */
@Entity
@Table(name="phenomenon")
@NamedQuery(name="PhenomenonEntity.findAll", query="SELECT p FROM PhenomenonEntity p")
public class PhenomenonEntity extends EntityQueryable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String unitDesc;
	private List<SensorEntity> sensors;

	public PhenomenonEntity() {
	}


	@Id
	@SequenceGenerator(name="PHENOMENON_ID_GENERATOR", sequenceName="SEQ_PHENOMENON")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PHENOMENON_ID_GENERATOR")
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


	@Column(name="unit_desc")
	public String getUnitDesc() {
		return this.unitDesc;
	}

	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}


	//bi-directional many-to-one association to SensorEntity
	@OneToMany(mappedBy="phenomenon")
	public List<SensorEntity> getSensors() {
		return this.sensors;
	}

	public void setSensors(List<SensorEntity> sensors) {
		this.sensors = sensors;
	}

	public SensorEntity addSensor(SensorEntity sensor) {
		getSensors().add(sensor);
		sensor.setPhenomenon(this);

		return sensor;
	}

	public SensorEntity removeSensor(SensorEntity sensor) {
		getSensors().remove(sensor);
		sensor.setPhenomenon(null);

		return sensor;
	}

}