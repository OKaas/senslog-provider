package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by OK on 7/3/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String userName;

    public User() {
    }

    /* --- Getters / Setters --- */

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


