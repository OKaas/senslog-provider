package cz.hsrs.maplog.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the alert_event database table.
 * 
 */
@Entity
@Table(name="alert_event")
@NamedQuery(name="AlertEventEntity.findAll", query="SELECT a FROM AlertEventEntity a")
public class AlertEventEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long alertId;
	private Timestamp timeStamp;
	private AlertEntity alert;
	private EnumItemEntity enumItem;
	private UnitEntity unit;

	public AlertEventEntity() {
	}


	@Id
	@SequenceGenerator(name="ALERT_EVENT_ID_GENERATOR", sequenceName="SEQ_ALERT_EVENT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALERT_EVENT_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="alert_id")
	public Long getAlertId() {
		return this.alertId;
	}

	public void setAlertId(Long alertId) {
		this.alertId = alertId;
	}


	@Column(name="time_stamp")
	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	//bi-directional one-to-one association to AlertEntity
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public AlertEntity getAlert() {
		return this.alert;
	}

	public void setAlert(AlertEntity alert) {
		this.alert = alert;
	}


	//bi-directional many-to-one association to EnumItemEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="enum_item_id")
	public EnumItemEntity getEnumItem() {
		return this.enumItem;
	}

	public void setEnumItem(EnumItemEntity enumItem) {
		this.enumItem = enumItem;
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