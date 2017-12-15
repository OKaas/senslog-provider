package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Observation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class ObservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservationController.class);

    private static final String PREFIX_CONTROLLER = "/observation";


    /* --- REST calls --- */
    /***
     * /{client-id}/observation/insert?unitId={unitId}&sensorId={sensorId}
     *
     * @param clientId
     * @param unitId
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertObservation(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                        @RequestParam(value = RestMapping.UNIT_ID, required = false) String unitId,
                                        @RequestParam(value = RestMapping.SENSOR_ID, required = false) String sensorId,
                                        @RequestBody Observation observation){

        LOGGER.info("> clientId {}, unitId {}, sensorId {}, observation {}", clientId, unitId, sensorId, observation);
        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


