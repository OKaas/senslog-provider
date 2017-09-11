package cz.hsrs.maplog.db.entity;

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
	private Long gid;
	private Boolean solved;
	private Boolean solving;
	private Timestamp timeStamp;
	private Long unitId;
	private AlertEntity alert;
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


	public Long getGid() {
		return this.gid;
	}

	public void setGid(Long gid) {
		this.gid = gid;
	}


	public Boolean getSolved() {
		return this.solved;
	}

	public void setSolved(Boolean solved) {
		this.solved = solved;
	}


	public Boolean getSolving() {
		return this.solving;
	}

	public void setSolving(Boolean solving) {
		this.solving = solving;
	}


	@Column(name="time_stamp")
	public Timestamp getTimeStamp() {
		return this.timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	@Column(name="unit_id")
	public Long getUnitId() {
		return this.unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
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


	//bi-directional one-to-one association to UnitEntity
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id")
	public UnitEntity getUnit() {
		return this.unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}

}