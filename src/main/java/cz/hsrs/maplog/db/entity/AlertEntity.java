package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the alerts database table.
 * 
 */
@Entity
@Table(name="alerts")
@NamedQuery(name="AlertEntity.findAll", query="SELECT a FROM AlertEntity a")
public class AlertEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer alertId;
	private String alertDescription;
	private List<AlertEventsEntity> alertEvents;

	public AlertEntity() {
	}


	@Id
	@SequenceGenerator(name="ALERTS_ALERTID_GENERATOR", sequenceName="SEQ_ALERTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALERTS_ALERTID_GENERATOR")
	@Column(name="alert_id")
	public Integer getAlertId() {
		return this.alertId;
	}

	public void setAlertId(Integer alertId) {
		this.alertId = alertId;
	}


	@Column(name="alert_description")
	public String getAlertDescription() {
		return this.alertDescription;
	}

	public void setAlertDescription(String alertDescription) {
		this.alertDescription = alertDescription;
	}


	//bi-directional many-to-one association to AlertEventsEntity
	@OneToMany(mappedBy="alert")
	public List<AlertEventsEntity> getAlertEvents() {
		return this.alertEvents;
	}

	public void setAlertEvents(List<AlertEventsEntity> alertEvents) {
		this.alertEvents = alertEvents;
	}

	public AlertEventsEntity addAlertEvent(AlertEventsEntity alertEvent) {
		getAlertEvents().add(alertEvent);
		alertEvent.setAlert(this);

		return alertEvent;
	}

	public AlertEventsEntity removeAlertEvent(AlertEventsEntity alertEvent) {
		getAlertEvents().remove(alertEvent);
		alertEvent.setAlert(null);

		return alertEvent;
	}

}