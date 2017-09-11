package cz.hsrs.maplog.rest.dto;


import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
public class Unit {

    private Long id;
    private String description;
    private Boolean isMobile;
    private AlertEvent alertEvent;
    private List<Observation> observations;
    private UnitHolder unitHolder;
    private List<UnitPosition> unitsPositions;

    public Unit() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getMobile() {
        return isMobile;
    }

    public void setMobile(Boolean mobile) {
        isMobile = mobile;
    }

    public AlertEvent getAlertEvent() {
        return alertEvent;
    }

    public void setAlertEvent(AlertEvent alertEvent) {
        this.alertEvent = alertEvent;
    }

    public List<Observation> getObservations() {
        return observations;
    }

    public void setObservations(List<Observation> observations) {
        this.observations = observations;
    }

    public UnitHolder getUnitHolder() {
        return unitHolder;
    }

    public void setUnitHolder(UnitHolder unitHolder) {
        this.unitHolder = unitHolder;
    }

    public List<UnitPosition> getUnitsPositions() {
        return unitsPositions;
    }

    public void setUnitsPositions(List<UnitPosition> unitsPositions) {
        this.unitsPositions = unitsPositions;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isMobile=" + isMobile +
                ", alertEvent=" + alertEvent +
                ", observations=" + observations +
                ", unitHolder=" + unitHolder +
                ", unitsPositions=" + unitsPositions +
                '}';
    }
}


