package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the unit_holder database table.
 * 
 */
@Entity
@Table(name="unit_holder")
@NamedQuery(name="UnitHolderEntity.findAll", query="SELECT u FROM UnitHolderEntity u")
public class UnitHolderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String address;
	private String email;
	private Long iconId;
	private String name;
	private String phone;
	private String www;
	private UnitEntity unit;

	public UnitHolderEntity() {
	}


	@Id
	@SequenceGenerator(name="UNIT_HOLDER_ID_GENERATOR", sequenceName="SEQ_UNIT_HOLDER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIT_HOLDER_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="icon_id")
	public Long getIconId() {
		return this.iconId;
	}

	public void setIconId(Long iconId) {
		this.iconId = iconId;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getWww() {
		return this.www;
	}

	public void setWww(String www) {
		this.www = www;
	}


	//bi-directional one-to-one association to UnitEntity
	@OneToOne(mappedBy="unitHolder", fetch=FetchType.LAZY)
	public UnitEntity getUnit() {
		return this.unit;
	}

	public void setUnit(UnitEntity unit) {
		this.unit = unit;
	}

}