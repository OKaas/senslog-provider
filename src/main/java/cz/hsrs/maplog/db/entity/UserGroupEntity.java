package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
@NamedQuery(name="UserGroupEntity.findAll", query="SELECT u FROM UserGroupEntity u")
public class UserGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String groupName;
	private Boolean hasChildren;
	private UserGroupEntity group;
	private List<UserGroupEntity> groups;
	private List<UserEntity> systemUsers;

	public UserGroupEntity() {
	}


	@Id
	@SequenceGenerator(name="GROUPS_ID_GENERATOR", sequenceName="SEQ_GROUPS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUPS_ID_GENERATOR")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="group_name")
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	@Column(name="has_children")
	public Boolean getHasChildren() {
		return this.hasChildren;
	}

	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}


	//bi-directional many-to-one association to UserGroupEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_group_id")
	public UserGroupEntity getGroup() {
		return this.group;
	}

	public void setGroup(UserGroupEntity group) {
		this.group = group;
	}


	//bi-directional many-to-one association to UserGroupEntity
	@OneToMany(mappedBy="group")
	public List<UserGroupEntity> getGroups() {
		return this.groups;
	}

	public void setGroups(List<UserGroupEntity> groups) {
		this.groups = groups;
	}

	public UserGroupEntity addGroup(UserGroupEntity group) {
		getGroups().add(group);
		group.setGroup(this);

		return group;
	}

	public UserGroupEntity removeGroup(UserGroupEntity group) {
		getGroups().remove(group);
		group.setGroup(null);

		return group;
	}


	//bi-directional many-to-one association to UserEntity
	@OneToMany(mappedBy="group")
	public List<UserEntity> getSystemUsers() {
		return this.systemUsers;
	}

	public void setSystemUsers(List<UserEntity> systemUsers) {
		this.systemUsers = systemUsers;
	}

	public UserEntity addSystemUser(UserEntity systemUser) {
		getSystemUsers().add(systemUser);
		systemUser.setGroup(this);

		return systemUser;
	}

	public UserEntity removeSystemUser(UserEntity systemUser) {
		getSystemUsers().remove(systemUser);
		systemUser.setGroup(null);

		return systemUser;
	}

}