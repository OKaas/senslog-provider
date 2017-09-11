package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.repository.ObservationRepository;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.db.repository.UnitRepository;
import cz.hsrs.maplog.rest.dto.Unit;
import cz.hsrs.maplog.util.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by OK on 7/4/2017.
 */
@RestController
public class UnitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitController.class);

    private static final String PREFIX_CONTROLLER = "/unit";

    @Autowired
    private Mapper objectMapper;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ObservationRepository observationRepository;

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
                                @RequestParam(value = RestMapping.SORT, required = false) String sort ){

        LOGGER.info("> clientId {}, sort {}", clientId, sort);
        return null;
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
                        @RequestParam(value = RestMapping.PATH_UNIT_ID) String unitId ){

        LOGGER.info("> clientId {}, sort {}", clientId, unitId);
        return null;
    }

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

//    @RequestMapping(value = RestMapping.PATH_CLIENT_ID +PREFIX_CONTROLLER+"/insert/{id}", method = RequestMethod.POST)
//    public HttpStatus insertUnit(@PathVariable(RestMapping.CLIENT_ID) long id, @RequestBody Unit unit) {
//
//        LOGGER.info(unit.toString());
//
//        UnitEntity entity = (UnitEntity) objectMapper.convertToEntity(unit, UnitEntity.class);
//        entity.setId(id);
//
//        unitRepository.save(entity);
//
//        return HttpStatus.OK;
//    }
//
//    @RequestMapping(value = RestMapping.PATH_CLIENT_ID +PREFIX_CONTROLLER+"/insert", method = RequestMethod.POST)
//    public HttpStatus insertUnitList(@RequestBody List<Unit> unit) {
//
//        LOGGER.info(unit.toString());
//
//        List<UnitEntity> entity = objectMapper.toUnitEntity(unit);
//
//        unitRepository.save(entity);
//
//        return HttpStatus.OK;
//    }
//
//    @RequestMapping(value = RestMapping.PATH_CLIENT_ID +PREFIX_CONTROLLER+"/insert/observation", method = RequestMethod.POST)
//    public HttpStatus insertObservationToUnit(@RequestBody Observation observation) {
//
//        LOGGER.info(observation.toString());
//
//        observationRepository.save( objectMapper.toObservationEntity(observation) );
//
//        return HttpStatus.OK;
//    }
//
//    @RequestMapping(value = RestMapping.PATH_CLIENT_ID +PREFIX_CONTROLLER+"/insert/position", method = RequestMethod.POST)
//    public HttpStatus insertPositionToUnit(@RequestBody Position position) {
//
//        PositionEntity entity = (PositionEntity) objectMapper.convertToEntity(position, PositionEntity.class);
//
//        positionRepository.save(entity);
//
//        return HttpStatus.OK;
//    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


