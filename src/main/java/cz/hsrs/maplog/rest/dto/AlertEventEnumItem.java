package cz.hsrs.maplog.rest.dto;

/**
 * Created by OK on 1/21/2018.
 */
public class AlertEventEnumItem {

    private Long id;
    private String name;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "AlertEventEnumItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


