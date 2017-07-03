package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the alert_events database table.
 * 
 */
@Entity
@Table(name="alert_events")
@NamedQuery(name="AlertEventsEntity.findAll", query="SELECT a FROM AlertEventsEntity a")
public class AlertEventsEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer alertEventId;
	private Integer gid;
	private Boolean solved;
	private Boolean solving;
	private Timestamp timeStamp;
	private AlertEntity alert;
	private UnitEntity unit;

	public AlertEventsEntity() {
	}


	@Id
	@SequenceGenerator(name="ALERT_EVENTS_ALERTEVENTID_GENERATOR", sequenceName="SEQ_ALERT_EVENTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALERT_EVENTS_ALERTEVENTID_GENERATOR")
	@Column(name="alert_event_id")
	public Integer getAlertEventId() {
		return this.alertEventId;
	}

	public void setAlertEventId(Integer alertEventId) {
		this.alertEventId = alertEventId;
	}


	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
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


	//bi-directional many-to-one association to AlertEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="alert_id")
	public AlertEntity getAlert() {
		return this.alert;
	}

	public void setAlert(AlertEntity alert) {
		this.alert = alert;
	}


	//bi-directional many-to-one association to UnitEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="unit_id")
	public UnitEntity getUnit() {
		return this.unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}

}