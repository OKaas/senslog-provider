package cz.hsrs.maplog.rest.dto;

import cz.hsrs.maplog.rest.dto.receive.Position;
import cz.hsrs.maplog.rest.dto.receive.Sensor;

import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
public class Unit {

    private Long id;
    private String description;
    private Boolean isMobile;
    private AlertEvent alertEvent;
    private List<AlertEvent> alertEvents;
    private List<Position> positions;
    private List<Sensor> sensors;
    private List<UnitToGroup> unitToGroups;

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

    public List<AlertEvent> getAlertEvents() {
        return alertEvents;
    }

    public void setAlertEvents(List<AlertEvent> alertEvents) {
        this.alertEvents = alertEvents;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public List<UnitToGroup> getUnitToGroups() {
        return unitToGroups;
    }

    public void setUnitToGroups(List<UnitToGroup> unitToGroups) {
        this.unitToGroups = unitToGroups;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "Unit{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isMobile=" + isMobile +
                ", alertEvent=" + alertEvent +
                ", alertEvents=" + alertEvents +
                ", positions=" + positions +
                ", sensors=" + sensors +
                ", unitToGroups=" + unitToGroups +
                '}';
    }
}


