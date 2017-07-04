package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user_group database table.
 * 
 */
@Entity
@Table(name="user_group")
@NamedQuery(name="UserGroupEntity.findAll", query="SELECT u FROM UserGroupEntity u")
public class UserGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean hasChildren;
	private String name;
	private List<UserEntity> users;
	private UserGroupEntity userGroup;
	private List<UserGroupEntity> userGroups;

	public UserGroupEntity() {
	}


	@Id
	@SequenceGenerator(name="USER_GROUP_ID_GENERATOR", sequenceName="SEQ_USER_GROUP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_GROUP_ID_GENERATOR")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	@Column(name="has_children")
	public Boolean getHasChildren() {
		return this.hasChildren;
	}

	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	//bi-directional many-to-one association to UserEntity
	@OneToMany(mappedBy="userGroup")
	public List<UserEntity> getUsers() {
		return this.users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public UserEntity addUser(UserEntity user) {
		getUsers().add(user);
		user.setUserGroup(this);

		return user;
	}

	public UserEntity removeUser(UserEntity user) {
		getUsers().remove(user);
		user.setUserGroup(null);

		return user;
	}


	//bi-directional many-to-one association to UserGroupEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_group_id")
	public UserGroupEntity getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroupEntity userGroup) {
		this.userGroup = userGroup;
	}


	//bi-directional many-to-one association to UserGroupEntity
	@OneToMany(mappedBy="userGroup")
	public List<UserGroupEntity> getUserGroups() {
		return this.userGroups;
	}

	public void setUserGroups(List<UserGroupEntity> userGroups) {
		this.userGroups = userGroups;
	}

	public UserGroupEntity addUserGroup(UserGroupEntity userGroup) {
		getUserGroups().add(userGroup);
		userGroup.setUserGroup(this);

		return userGroup;
	}

	public UserGroupEntity removeUserGroup(UserGroupEntity userGroup) {
		getUserGroups().remove(userGroup);
		userGroup.setUserGroup(null);

		return userGroup;
	}

}