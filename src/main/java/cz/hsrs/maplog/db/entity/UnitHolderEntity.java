package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the unit_holders database table.
 * 
 */
@Entity
@Table(name="unit_holders")
@NamedQuery(name="UnitHolderEntity.findAll", query="SELECT u FROM UnitHolderEntity u")
public class UnitHolderEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer holderId;
	private String address;
	private String email;
	private String holderName;
	private Integer iconId;
	private String phone;
	private String www;
	private List<UnitEntity> units;

	public UnitHolderEntity() {
	}


	@Id
	@SequenceGenerator(name="UNIT_HOLDERS_HOLDERID_GENERATOR", sequenceName="SEQ_UNIT_HOLDERS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="UNIT_HOLDERS_HOLDERID_GENERATOR")
	@Column(name="holder_id")
	public Integer getHolderId() {
		return this.holderId;
	}

	public void setHolderId(Integer holderId) {
		this.holderId = holderId;
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


	@Column(name="holder_name")
	public String getHolderName() {
		return this.holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}


	@Column(name="icon_id")
	public Integer getIconId() {
		return this.iconId;
	}

	public void setIconId(Integer iconId) {
		this.iconId = iconId;
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


	//bi-directional many-to-one association to UnitEntity
	@OneToMany(mappedBy="unitHolder")
	public List<UnitEntity> getUnits() {
		return this.units;
	}

	public void setUnits(List<UnitEntity> units) {
		this.units = units;
	}

	public UnitEntity addUnit(UnitEntity unit) {
		getUnits().add(unit);
		unit.setUnitHolder(this);

		return unit;
	}

	public UnitEntity removeUnit(UnitEntity unit) {
		getUnits().remove(unit);
		unit.setUnitHolder(null);

		return unit;
	}

}