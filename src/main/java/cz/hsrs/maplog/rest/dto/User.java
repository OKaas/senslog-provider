package cz.hsrs.maplog.rest.dto;

/**
 * Created by OK on 6/9/2017.
 */
public class User {

    private String user;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                '}';
    }
}


