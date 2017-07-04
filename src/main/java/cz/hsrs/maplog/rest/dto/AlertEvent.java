package cz.hsrs.maplog.rest.dto;

import cz.hsrs.maplog.db.entity.AlertEntity;
import cz.hsrs.maplog.db.entity.UnitEntity;

import java.sql.Timestamp;

/**
 * Created by OK on 7/4/2017.
 */
public class AlertEvent {

    private Integer id;
    private Integer alertId;
    private Integer gid;
    private Boolean solved;
    private Boolean solving;
    private Timestamp timeStamp;
    private Long unitId;
    private Alert alert;
    private Unit unit;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


