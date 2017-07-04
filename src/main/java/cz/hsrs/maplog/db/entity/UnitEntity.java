package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
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
	private Integer holderId;
	private Boolean isMobile;
	private AlertEventEntity alertEvent;
	private List<ObservationEntity> observations;
	private UnitHolderEntity unitHolder;
	private List<UnitPositionEntity> unitsPositions;

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


	@Column(name="holder_id")
	public Integer getHolderId() {
		return this.holderId;
	}

	public void setHolderId(Integer holderId) {
		this.holderId = holderId;
	}


	@Column(name="is_mobile")
	public Boolean getIsMobile() {
		return this.isMobile;
	}

	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}


	//bi-directional one-to-one association to AlertEventEntity
	@OneToOne(mappedBy="unit", fetch=FetchType.LAZY)
	public AlertEventEntity getAlertEvent() {
		return this.alertEvent;
	}

	public void setAlertEvent(AlertEventEntity alertEvent) {
		this.alertEvent = alertEvent;
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


	//bi-directional one-to-one association to UnitHolderEntity
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public UnitHolderEntity getUnitHolder() {
		return this.unitHolder;
	}

	public void setUnitHolder(UnitHolderEntity unitHolder) {
		this.unitHolder = unitHolder;
	}


	//bi-directional many-to-one association to UnitPositionEntity
	@OneToMany(mappedBy="unit")
	public List<UnitPositionEntity> getUnitsPositions() {
		return this.unitsPositions;
	}

	public void setUnitsPositions(List<UnitPositionEntity> unitsPositions) {
		this.unitsPositions = unitsPositions;
	}

	public UnitPositionEntity addUnitsPosition(UnitPositionEntity unitsPosition) {
		getUnitsPositions().add(unitsPosition);
		unitsPosition.setUnit(this);

		return unitsPosition;
	}

	public UnitPositionEntity removeUnitsPosition(UnitPositionEntity unitsPosition) {
		getUnitsPositions().remove(unitsPosition);
		unitsPosition.setUnit(null);

		return unitsPosition;
	}

}