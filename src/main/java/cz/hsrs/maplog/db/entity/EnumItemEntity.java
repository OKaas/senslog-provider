package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the enum_item database table.
 * 
 */
@Entity
@Table(name="enum_item")
@NamedQuery(name="EnumItemEntity.findAll", query="SELECT e FROM EnumItemEntity e")
public class EnumItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private List<AlertEventEntity> alertEvents;

	public EnumItemEntity() {
	}


	@Id
	@SequenceGenerator(name="ENUM_ITEM_ID_GENERATOR", sequenceName="SEQ_ENUM_ITEM")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ENUM_ITEM_ID_GENERATOR")
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


	//bi-directional many-to-one association to AlertEventEntity
	@OneToMany(mappedBy="enumItem")
	public List<AlertEventEntity> getAlertEvents() {
		return this.alertEvents;
	}

	public void setAlertEvents(List<AlertEventEntity> alertEvents) {
		this.alertEvents = alertEvents;
	}

	public AlertEventEntity addAlertEvent(AlertEventEntity alertEvent) {
		getAlertEvents().add(alertEvent);
		alertEvent.setEnumItem(this);

		return alertEvent;
	}

	public AlertEventEntity removeAlertEvent(AlertEventEntity alertEvent) {
		getAlertEvents().remove(alertEvent);
		alertEvent.setEnumItem(null);

		return alertEvent;
	}

}