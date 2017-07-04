package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by OK on 7/3/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private Integer id;
    private Boolean audio;
    private String lang;
    private Boolean moduleAdministrator;
    private Boolean moduleLogBook;
    private String name;
    private String password;
    private String realName;
    private Integer rightsId;

    public User() {
    }

    /* --- Getters / Setters --- */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getAudio() {
        return audio;
    }

    public void setAudio(Boolean audio) {
        this.audio = audio;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Boolean getModuleAdministrator() {
        return moduleAdministrator;
    }

    public void setModuleAdministrator(Boolean moduleAdministrator) {
        this.moduleAdministrator = moduleAdministrator;
    }

    public Boolean getModuleLogBook() {
        return moduleLogBook;
    }

    public void setModuleLogBook(Boolean moduleLogBook) {
        this.moduleLogBook = moduleLogBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getRightsId() {
        return rightsId;
    }

    public void setRightsId(Integer rightsId) {
        this.rightsId = rightsId;
    }
}


