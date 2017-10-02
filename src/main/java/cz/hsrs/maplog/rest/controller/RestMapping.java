package cz.hsrs.maplog.rest.controller;

import org.springframework.http.HttpStatus;

/**
 * Created by OK on 9/11/2017.
 */
public class RestMapping {

    protected static final String PATH_INSERT = "/insert";
    protected static final String PATH_ALL = "/all";
    protected static final String PATH_VALUE = "/value";

    protected static final String SORT = "sort";
    protected static final String MOBILE = "mobile";
    protected static final String TIME = "time";


    protected static final String CLIENT_ID = "clientId";
    protected static final String PATH_CLIENT_ID = "/{"+CLIENT_ID+"}";

    protected static final String UNIT_ID = "unitId";
    protected static final String PATH_UNIT_ID = "/{"+UNIT_ID+"}";

    protected static final String SENSOR_ID = "sensorId";
    protected static final String PATH_SENSOR_ID = "/{"+SENSOR_ID+"}";

    protected static final String POSITION_ID = "positionId";
    protected static final String PATH_POSITION_ID = "/{"+POSITION_ID+"}";

    protected static final String PHENOMENON_ID = "phenomenonId";
    protected static final String PATH_PHENOMENON_ID = "/{"+PHENOMENON_ID+"}";

    protected static final String PHENOMENON_NAME = "phenomenonName";
    protected static final String PATH_PHENOMENON_NAME = "/{"+PHENOMENON_NAME+"}";

    protected static final String ALERT_ID = "alertId";
    protected static final String PATH_ALERT_ID = "/{"+ALERT_ID+"}";

    /* --- HTTP STATUS --- */
    protected static final HttpStatus STATUS_CREATED = HttpStatus.CREATED;
    protected static final HttpStatus STATUS_BAD_REQUEST = HttpStatus.BAD_REQUEST;


    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


