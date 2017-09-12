package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.rest.dto.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class PositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    private static final String PREFIX_CONTROLLER = "/position";

    /***
     * /{client-id}/position?unitId={unitId}
     *
     * @param clientId
     * @param unitId
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getPosition(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                      @RequestParam(value = RestMapping.UNIT_ID) String unitId){

        LOGGER.info("> clientId {}, unitId {}", clientId, unitId);
        return null;
    }

    /***
     * /{client-id}/position/insert?unitId={unitId}
     *
     * @param clientId
     * @param unitId
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.GET)
    public HttpStatus insertPosition(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                     @RequestParam(value = RestMapping.UNIT_ID) String unitId,
                                     @RequestBody Position position){

        LOGGER.info("> clientId {}, unitId {}, position {}", clientId, unitId, position);
        return RestMapping.STATUS_CREATED;
    }

    /***
     * /{client-id}/position?positionId={positioId}&unitId={unitId}&sort={sort}
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getPositionByUnitPosition(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                              @RequestParam(value = RestMapping.UNIT_ID) String unitId,
                                              @RequestParam(value = RestMapping.POSITION_ID, required = false) String positionId,
                                              @RequestParam(value = RestMapping.SORT, required = false) String sort){

        LOGGER.info("> clientId {}, unitId {}, position {}, sort {}", clientId, unitId, positionId, sort);
        return null;
    }


    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


