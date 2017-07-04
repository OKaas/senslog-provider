package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the alert database table.
 * 
 */
@Entity
@Table(name="alert")
@NamedQuery(name="AlertEntity.findAll", query="SELECT a FROM AlertEntity a")
public class AlertEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String description;
	private AlertEventEntity alertEvent;

	public AlertEntity() {
	}


	@Id
	@SequenceGenerator(name="ALERT_ID_GENERATOR", sequenceName="SEQ_ALERT")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ALERT_ID_GENERATOR")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	//bi-directional one-to-one association to AlertEventEntity
	@OneToOne(mappedBy="alert", fetch=FetchType.LAZY)
	public AlertEventEntity getAlertEvent() {
		return this.alertEvent;
	}

	public void setAlertEvent(AlertEventEntity alertEvent) {
		this.alertEvent = alertEvent;
	}

}