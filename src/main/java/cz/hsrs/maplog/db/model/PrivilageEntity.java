package cz.hsrs.maplog.db.model;

import cz.hsrs.maplog.db.queryspecification.EntityQueryable;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the privilages database table.
 * 
 */
@Entity
@Table(name="privilages")
@NamedQuery(name="PrivilageEntity.findAll", query="SELECT p FROM PrivilageEntity p")
public class PrivilageEntity extends EntityQueryable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String noteCz;
	private String userRole;

	public PrivilageEntity() {
	}


	@Id
	@SequenceGenerator(name="PRIVILAGES_ID_GENERATOR", sequenceName="SEQ_PRIVILAGES")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRIVILAGES_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="note_cz")
	public String getNoteCz() {
		return this.noteCz;
	}

	public void setNoteCz(String noteCz) {
		this.noteCz = noteCz;
	}


	@Column(name="user_role")
	public String getUserRole() {
		return this.userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

}