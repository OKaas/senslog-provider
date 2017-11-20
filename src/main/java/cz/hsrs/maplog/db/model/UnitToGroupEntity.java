package cz.hsrs.maplog.db.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the unit_to_group database table.
 * 
 */
@Entity
@Table(name="unit_to_group")
@NamedQuery(name="UnitToGroupEntity.findAll", query="SELECT u FROM UnitToGroupEntity u")
public class UnitToGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;

	@JsonBackReference
	private UnitEntity unit;
	@JsonBackReference
	private UserGroupEntity userGroup;

	public UnitToGroupEntity() {
	}


	@Id
	@SequenceGenerator(name="UNIT_TO_GROUP_ID_GENERATOR", sequenceName="SEQ_UNIT_TO_GROUP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIT_TO_GROUP_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	//bi-directional many-to-one association to UnitEntity
	@ManyToOne(fetch=FetchType.LAZY)
	public UnitEntity getUnit() {
		return this.unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}


	//bi-directional many-to-one association to UserGroupEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_group_id")
	public UserGroupEntity getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroupEntity userGroup) {
		this.userGroup = userGroup;
	}

}