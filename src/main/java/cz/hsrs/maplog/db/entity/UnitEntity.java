package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the units database table.
 * 
 */
@Entity
@Table(name="units")
@NamedQuery(name="UnitEntity.findAll", query="SELECT u FROM UnitEntity u")
public class UnitEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long unitId;
	private String description;
	private Boolean isMobile;
	private List<AlertEventsEntity> alertEvents;
	private List<ObservationEntity> observations;
	private UnitHolderEntity unitHolder;
	private List<UnitsPositionEntity> unitsPositions;

	public UnitEntity() {
	}


	@Id
	@SequenceGenerator(name="UNITS_UNITID_GENERATOR", sequenceName="SEQ_UNITS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNITS_UNITID_GENERATOR")
	@Column(name="unit_id")
	public Long getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
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


	//bi-directional many-to-one association to AlertEventsEntity
	@OneToMany(mappedBy="unit")
	public List<AlertEventsEntity> getAlertEvents() {
		return this.alertEvents;
	}

	public void setAlertEvents(List<AlertEventsEntity> alertEvents) {
		this.alertEvents = alertEvents;
	}

	public AlertEventsEntity addAlertEvent(AlertEventsEntity alertEvent) {
		getAlertEvents().add(alertEvent);
		alertEvent.setUnit(this);

		return alertEvent;
	}

	public AlertEventsEntity removeAlertEvent(AlertEventsEntity alertEvent) {
		getAlertEvents().remove(alertEvent);
		alertEvent.setUnit(null);

		return alertEvent;
	}


	//bi-directional many-to-one association to ObservationEntity
	@OneToMany(mappedBy="unit")
	public List<ObservationEntity> getObservations() {
		return this.observations;
	}

	public void setObservations(List<ObservationEntity> observations) {
		this.observations = observations;
	}

	public ObservationEntity addObservation(ObservationEntity observation) {
		getObservations().add(observation);
		observation.setUnit(this);

		return observation;
	}

	public ObservationEntity removeObservation(ObservationEntity observation) {
		getObservations().remove(observation);
		observation.setUnit(null);

		return observation;
	}


	//bi-directional many-to-one association to UnitHolderEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="holder_id")
	public UnitHolderEntity getUnitHolder() {
		return this.unitHolder;
	}

	public void setUnitHolder(UnitHolderEntity unitHolder) {
		this.unitHolder = unitHolder;
	}


	//bi-directional many-to-one association to UnitsPositionEntity
	@OneToMany(mappedBy="unit")
	public List<UnitsPositionEntity> getUnitsPositions() {
		return this.unitsPositions;
	}

	public void setUnitsPositions(List<UnitsPositionEntity> unitsPositions) {
		this.unitsPositions = unitsPositions;
	}

	public UnitsPositionEntity addUnitsPosition(UnitsPositionEntity unitsPosition) {
		getUnitsPositions().add(unitsPosition);
		unitsPosition.setUnit(this);

		return unitsPosition;
	}

	public UnitsPositionEntity removeUnitsPosition(UnitsPositionEntity unitsPosition) {
		getUnitsPositions().remove(unitsPosition);
		unitsPosition.setUnit(null);

		return unitsPosition;
	}

}