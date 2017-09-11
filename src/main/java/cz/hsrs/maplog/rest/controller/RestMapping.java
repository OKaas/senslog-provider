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


    protected static final String CLIENT_ID = "clientId";
    protected static final String PATH_CLIENT_ID = "/{"+CLIENT_ID+"}";

    protected static final String UNIT_ID = "unitId";
    protected static final String PATH_UNIT_ID = "/{"+UNIT_ID+"}";

    protected static final String SENSOR_ID = "sensorId";
    protected static final String PATH_SENSOR_ID = "/{"+SENSOR_ID+"}";


    /* --- HTTP STATUS --- */
    protected static final HttpStatus STATUS_CREATED = HttpStatus.CREATED;

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


