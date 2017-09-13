package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.rest.dto.Phenomenon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class PhenomenonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhenomenonController.class);

    private static final String PREFIX_CONTROLLER = "/phenomenon";

    /***
     * /{client-id}/phenomenon/all
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_ALL, method = RequestMethod.GET)
    @ResponseBody
    public List<Phenomenon> getPhenomenonAll(@PathVariable(RestMapping.CLIENT_ID) String clientId){

        LOGGER.info("> clientId {} ", clientId);
        return null;
    }

    /***
     * /{client-id}/phenomenon?unitId={unitId}
     * /{client-id}/phenomenon?phenomenonId={phenomenonId}&unitId={unitId}
     * /{client-id}/phenomenon?phenomenonName={phenomenonName}&unitId={unitId}
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Phenomenon> getPhenomenon(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                                  @RequestParam( value = RestMapping.UNIT_ID) String unitId,
                                                  @RequestParam(value = RestMapping.PHENOMENON_ID, required = false) String phenomenonId,
                                                    @RequestParam(value = RestMapping.PHENOMENON_NAME, required = false) String phenomenonName){

        LOGGER.info("> clientId {}, unitId {}, phenomenonId {}, phenomenonName {} ", clientId, unitId, phenomenonId, phenomenonName);
        return null;
    }

    /***
     * /{client-id}/phenomenon/insert
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertSensor(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                   @RequestParam( value = RestMapping.UNIT_ID) String unitId,
                                   @RequestParam(value = RestMapping.PHENOMENON_ID, required = false) String phenomenonId){

        LOGGER.info("> clientId {}, unitId {}, phenomenonId {} ", clientId, unitId, phenomenonId);
        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


