package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.repository.ObservationRepository;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.db.repository.UnitRepository;
import cz.hsrs.maplog.rest.dto.Unit;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
@RestController
public class UnitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitController.class);

    private static final String PREFIX_CONTROLLER = "/unit";

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ObservationRepository observationRepository;

    private final static Type TARGET_LIST = new TypeToken<List<Unit>>() {}.getType();

    /* --- REST calls --- */

    /* --- GET calls --- */

    /***
     * /{client-id}/unit/all
     * /{client-id}/unit/all?sort={static}
     * /{client-id}/unit/all?sort={mobile}
     *
     * @param clientId
     * @param sort
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_ALL, method = RequestMethod.GET)
    @ResponseBody
    public List<Unit> getAllUnit(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                @RequestParam(value = RestMapping.MOBILE, required = false) Boolean sort ){

        LOGGER.info("> clientId {}, sort {}", clientId, sort);

        return modelMapper.map(unitRepository.findAllUnitByUser(clientId, sort), TARGET_LIST);
    }

    /***
     * /{client-id}/unit?unitId={unitId}
     *
     * @param clientId
     * @param unitId
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public Unit getUnit(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                        @RequestParam(value = RestMapping.UNIT_ID) Long unitId ){

        LOGGER.info("> clientId {}, sort {}", clientId, unitId);
        return modelMapper.map(unitRepository.findAllUnitById(unitId), Unit.class);
    }

    /* --- POST CALLS --- */

    /***
     * /{client-id}/unit/insert
     *
     * @param clientId
     * @param unit
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertUnit(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                 @RequestParam List<Unit> unit){

        LOGGER.info("> clientId {}, units {}", clientId, unit);
        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


