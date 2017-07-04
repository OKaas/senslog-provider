package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rights database table.
 * 
 */
@Entity
@Table(name="rights")
@NamedQuery(name="RightEntity.findAll", query="SELECT r FROM RightEntity r")
public class RightEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String noteCz;
	private String userRole;

	public RightEntity() {
	}


	@Id
	@SequenceGenerator(name="RIGHTS_ID_GENERATOR", sequenceName="SEQ_RIGHTS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RIGHTS_ID_GENERATOR")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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