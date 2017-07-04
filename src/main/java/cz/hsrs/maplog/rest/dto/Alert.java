package cz.hsrs.maplog.rest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import cz.hsrs.maplog.db.entity.AlertEventEntity;

import java.util.Date;

/**
 * Created by OK on 6/12/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Alert {

    private Integer id;
    private String description;
    private AlertEvent alertEvent;
    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AlertEvent getAlertEvent() {
        return alertEvent;
    }

    public void setAlertEvent(AlertEvent alertEvent) {
        this.alertEvent = alertEvent;
    }
    /* --- Commons  --- */

}


