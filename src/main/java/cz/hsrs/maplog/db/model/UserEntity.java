package cz.hsrs.maplog.db.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="\"user\"")
@NamedQuery(name="UserEntity.findAll", query="SELECT u FROM UserEntity u")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Boolean audio;
	private String lang;
	private Boolean moduleAdministrator;
	private Boolean moduleLogBook;
	private String name;
	private String password;
	private String realName;

	private UserGroupEntity userGroup;

	public UserEntity() {
	}


	@Id
	@SequenceGenerator(name="USER_ID_GENERATOR", sequenceName="SEQ_USER")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USER_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(name="real_name")
	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}


	//bi-directional many-to-one association to UserGroupEntity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="group_id")
	public UserGroupEntity getUserGroup() {
		return this.userGroup;
	}

	public void setUserGroup(UserGroupEntity userGroup) {
		this.userGroup = userGroup;
	}

}