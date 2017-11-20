package cz.hsrs.maplog.rest.dto.receive;

/**
 * Created by OK on 8/4/2017.
 */
public class SensorReceive {

    private Long id;
    private String name;
    private String type;

    public SensorReceive() {
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "SensorReceive{" +
                "id=" + id +
                ", username='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

