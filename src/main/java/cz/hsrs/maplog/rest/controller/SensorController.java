package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.rest.dto.Sensor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by OK on 6/9/2017.
 */
@RestController
public class SensorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SensorController.class);

    private static final String PREFIX_CONTROLLER = "/sensor";


    /* --- REST calls --- */
    /***
     * /{client-id}/sensor/all?unitId={unitId}
     *
     * @param clientId
     * @param unitId
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_ALL, method = RequestMethod.GET)
    @ResponseBody
    public List<Sensor> getSensorsByUnit(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                         @RequestParam(value = RestMapping.UNIT_ID) String unitId){

        LOGGER.info("> clientId {}, unitId {}", clientId, unitId);
        return null;
    }

    /***
     * /{client-id}/sensor/value?unitId={unitId}&sort={sort}
     *
     * @param clientId
     * @param unitId
     * @param sort - sort type
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_VALUE, method = RequestMethod.GET)
    public String getSensorDataByUnit(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                      @RequestParam(value = RestMapping.UNIT_ID) String unitId,
                                      @RequestParam(value = RestMapping.SORT, required = false) String sort ){

        LOGGER.info("> clientId {}, unitId {}, sort {}", clientId, unitId, sort);
        return null;
    }

    /***
     * /{client-id}/sensor/insert?unitId={unitId}
     *
     * @param clientId
     * @param unitId
     * @param sensor - JSON with Id
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertSensor(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                   @RequestParam(value = RestMapping.UNIT_ID) String unitId,
                                   @RequestBody Sensor sensor){

        LOGGER.info("> clientId {},  unitId {}, sensor {}", clientId, unitId, sensor);
        return RestMapping.STATUS_CREATED;
    }

    /***
     * /{client-id}/sensor?sensorId={sensorId}
     *
     * @param clientId
     * @param sensorId
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.GET)
    public Sensor getSensor(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                            @RequestParam(value = RestMapping.SENSOR_ID) String sensorId){

        LOGGER.info("> clientId {},  sensorId {}", clientId, sensorId);
        return null;
    }

    /***
     * /{client-id}/sensor/value?unitId={unitId}&sensorId={sensorId}&sort={fromTime, toTime}
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.POST)
    public String getSensorValue(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                            @RequestParam(value = RestMapping.SENSOR_ID) String sensorId){

        LOGGER.info("> clientId {},  sensorId {}", clientId, sensorId);
        return null;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
}


