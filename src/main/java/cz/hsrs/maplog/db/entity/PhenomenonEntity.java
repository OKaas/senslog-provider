package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the phenomenons database table.
 * 
 */
@Entity
@Table(name="phenomenons")
@NamedQuery(name="PhenomenonEntity.findAll", query="SELECT p FROM PhenomenonEntity p")
public class PhenomenonEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String phenomenonId;
	private String phenomenonName;
	private String unit;
	private List<SensorEntity> sensors;

	public PhenomenonEntity() {
	}


	@Id
	@SequenceGenerator(name="PHENOMENONS_PHENOMENONID_GENERATOR", sequenceName="SEQ_PHENOMENONS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PHENOMENONS_PHENOMENONID_GENERATOR")
	@Column(name="phenomenon_id")
	public String getPhenomenonId() {
		return this.phenomenonId;
	}

	public void setPhenomenonId(String phenomenonId) {
		this.phenomenonId = phenomenonId;
	}


	@Column(name="phenomenon_name")
	public String getPhenomenonName() {
		return this.phenomenonName;
	}

	public void setPhenomenonName(String phenomenonName) {
		this.phenomenonName = phenomenonName;
	}


	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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