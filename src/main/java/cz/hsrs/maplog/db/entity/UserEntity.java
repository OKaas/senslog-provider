package cz.hsrs.maplog.db.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the system_users database table.
 * 
 */
@Entity
@Table(name="system_users")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Boolean audio;
	private String lang;
	private Boolean moduleAdministrator;
	private Boolean moduleLogBook;
	private Integer rightsId;
	private String userName;
	private String userPassword;
	private String userRealName;
	private UserGroupEntity group;

	public UserEntity() {
	}


	@Id
	@SequenceGenerator(name="SYSTEM_USERS_USERID_GENERATOR", sequenceName="SEQ_SYSTEM_USERS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SYSTEM_USERS_USERID_GENERATOR")
	@Column(name="user_id")
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Boolean getAudio() {
		return this.audio;
	}

	public void setAudio(Boolean audio) {
		this.audio = audio;
	}


	public String getLang() {
		return this.lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}


	@Column(name="module_administrator")
	public Boolean getModuleAdministrator() {
		return this.moduleAdministrator;
	}

	public void setModuleAdministrator(Boolean moduleAdministrator) {
		this.moduleAdministrator = moduleAdministrator;
	}


	@Column(name="module_log_book")
	public Boolean getModuleLogBook() {
		return this.moduleLogBook;
	}

	public void setModuleLogBook(Boolean moduleLogBook) {
		this.moduleLogBook = moduleLogBook;
	}


	@Column(name="rights_id")
	public Integer getRightsId() {
		return this.rightsId;
	}

	public void setRightsId(Integer rightsId) {
		this.rightsId = rightsId;
	}


	@Column(name="user_name")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Column(name="user_password")
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	@Column(name="user_real_name")
	public String getUserRealName() {
		return this.userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}


	//bi-directional many-to-one association to UserGroupEntity
	@ManyToOne(fetch=FetchType.LAZY)
	public UserGroupEntity getGroup() {
		return this.group;
	}

	public void setGroup(UserGroupEntity group) {
		this.group = group;
	}

}