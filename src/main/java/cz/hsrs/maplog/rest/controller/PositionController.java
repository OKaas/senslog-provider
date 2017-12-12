package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.PositionEntity;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.rest.dto.Position;
import cz.hsrs.maplog.rest.dto.receive.PositionReceive;
//import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.Mapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class PositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    private static final String PREFIX_CONTROLLER = "/position";
    private final static Type LIST_DTO = new TypeToken<List<Position>>() {}.getType();

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private Mapper modelMapper;

    /* --- GET calls --- */

    /***
     * /position?positionId={positioId}&unitId={unitId}&sort={sort}
     *
     * http://localhost:8080/position?unitId=1
     *
     * @return
     */
//    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
//    @ResponseBody
//    public List<Position> getPositionByUnit(@AuthenticationPrincipal UserToken token,
//                                            @RequestParam(value = RestMapping.UNIT_ID) Long unitId,
//                                            @RequestParam(value = RestMapping.POSITION_ID, required = false) String positionId,
//                                            @RequestParam(value = RestMapping.SEARCH, required = false) String sort){
//
//        LOGGER.info("> clientId {}, unitId {}, position {}, sort {}", unitId, positionId, sort);
//
//        return modelMapper.map(positionRepository.findAllByUnitIdAndUnitUnitToGroupsUserGroupIdIn(unitId, token.getGroup()), LIST_DTO);
//    }

    /* --- POST CALLS --- */

    /***
     * /{client-id}/unitPositionReceive/insert
     *
     * @return
     */
//    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
//    public HttpStatus insertPosition(@AuthenticationPrincipal UserToken token,
//                                     @RequestBody PositionReceive unitPositionReceive){
//
//        LOGGER.info("> clientId {}, unitPositionReceive {}", unitPositionReceive);
//
//        // PositionEntity positionEntity = modelMapper.map(unitPositionReceive, PositionEntity.class);
//
//        positionRepository.save(modelMapper.map(unitPositionReceive, PositionEntity.class));
//        return RestMapping.STATUS_CREATED;
//    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


