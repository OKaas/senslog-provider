package cz.hsrs.maplog.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the unit database table.
 * 
 */
@Entity
@Table(name="unit")
@NamedQuery(name="UnitEntity.findAll", query="SELECT u FROM UnitEntity u")
public class UnitEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String description;
	private Boolean isMobile;

	@JsonBackReference
	private AlertEventEntity alertEvent;
	@JsonManagedReference
	private List<AlertEventEntity> alertEvents;
	@JsonManagedReference
	private List<PositionEntity> positions;
	@JsonManagedReference
	private List<SensorEntity> sensors;
	@JsonManagedReference
	private List<UnitToGroupEntity> unitToGroups;

	public UnitEntity() {
	}


	@Id
	@SequenceGenerator(name="UNIT_ID_GENERATOR", sequenceName="SEQ_UNIT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIT_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Column(name="is_mobile")
	public Boolean getIsMobile() {
		return this.isMobile;
	}

	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}


	//uni-directional one-to-one association to AlertEventEntity
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public AlertEventEntity getAlertEvent() {
		return this.alertEvent;
	}

	public void setAlertEvent(AlertEventEntity alertEvent) {
		this.alertEvent = alertEvent;
	}


	//bi-directional many-to-one association to AlertEventEntity
	@OneToMany(mappedBy="unit")
	public List<AlertEventEntity> getAlertEvents() {
		return this.alertEvents;
	}

	public void setAlertEvents(List<AlertEventEntity> alertEvents) {
		this.alertEvents = alertEvents;
	}

	public AlertEventEntity addAlertEvent(AlertEventEntity alertEvent) {
		getAlertEvents().add(alertEvent);
		alertEvent.setUnit(this);

		return alertEvent;
	}

	public AlertEventEntity removeAlertEvent(AlertEventEntity alertEvent) {
		getAlertEvents().remove(alertEvent);
		alertEvent.setUnit(null);

		return alertEvent;
	}


	//bi-directional many-to-one association to PositionEntity
	@OneToMany(mappedBy="unit")
	public List<PositionEntity> getPositions() {
		return this.positions;
	}

	public void setPositions(List<PositionEntity> positions) {
		this.positions = positions;
	}

	public PositionEntity addPosition(PositionEntity position) {
		getPositions().add(position);
		position.setUnit(this);

		return position;
	}

	public PositionEntity removePosition(PositionEntity position) {
		getPositions().remove(position);
		position.setUnit(null);

		return position;
	}


	//bi-directional many-to-one association to SensorEntity
	@OneToMany(mappedBy="unit")
	public List<SensorEntity> getSensors() {
		return this.sensors;
	}

	public void setSensors(List<SensorEntity> sensors) {
		this.sensors = sensors;
	}

	public SensorEntity addSensor(SensorEntity sensor) {

		if( sensors == null ){
			sensors = new ArrayList<>();
		}

		getSensors().add(sensor);
		sensor.setUnit(this);

		return sensor;
	}

	public SensorEntity removeSensor(SensorEntity sensor) {
		getSensors().remove(sensor);
		sensor.setUnit(null);

		return sensor;
	}


	//bi-directional many-to-one association to UnitToGroupEntity
	@OneToMany(mappedBy="unit", cascade = CascadeType.ALL)
	public List<UnitToGroupEntity> getUnitToGroups() {
		return this.unitToGroups;
	}

	public void setUnitToGroups(List<UnitToGroupEntity> unitToGroups) {
		this.unitToGroups = unitToGroups;
	}

	public UnitToGroupEntity addUnitToGroup(UnitToGroupEntity unitToGroup) {

		if( unitToGroups == null ){
			unitToGroups = new ArrayList<>();
		}

		getUnitToGroups().add(unitToGroup);
		unitToGroup.setUnit(this);

		return unitToGroup;
	}

	public UnitToGroupEntity removeUnitToGroup(UnitToGroupEntity unitToGroup) {
		getUnitToGroups().remove(unitToGroup);
		unitToGroup.setUnit(null);

		return unitToGroup;
	}

}