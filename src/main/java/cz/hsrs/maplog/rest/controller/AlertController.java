package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.rest.dto.AlertEvent;
import cz.hsrs.maplog.rest.dto.Phenomenon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class AlertController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertController.class);

    private static final String PREFIX_CONTROLLER = "/alert";

    /***
     * /{client-id}/alert?alertId={alertId}&unitId={unitId}&sort={fromTime, toTime}
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<AlertEvent> getPhenomenonAll(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                             @RequestParam ( value = RestMapping.UNIT_ID) String unitId,
                                             @RequestParam (value = RestMapping.TIME, required = false) String time,
                                             @RequestParam( value = RestMapping.ALERT_ID, required = false) String alertId){

        LOGGER.info("> clientId {}, unitId {}, alertId {}, time {} ", clientId, unitId, alertId, time);
        return null;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


