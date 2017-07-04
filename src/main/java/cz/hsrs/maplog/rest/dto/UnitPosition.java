package cz.hsrs.maplog.rest.dto;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
public class UnitPosition {

    private Integer gid;
    private double altitude;
    private double dop;
    private Timestamp firstTimeStamp;
    private double speed;
    private Timestamp timeReceived;
    private Timestamp timeStamp;
    private List<Observation> observations;
    private Unit unit;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


