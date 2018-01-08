package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.queryspecification.specification.PositionForUnitInUserGroup;
import cz.hsrs.maplog.db.queryspecification.specification.UnitInUserGroup;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Position;
//import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.Mapper;
import cz.hsrs.maplog.util.QueryBuilder;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private QueryBuilder queryBuilder;

    @Autowired
    private Mapper modelMapper;

    /* --- GET calls --- */

    /***
     * /position?unitId=
     *
     * http://localhost:8080/position?unitId=1
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getPosition(@AuthenticationPrincipal UserToken token,
                                      @RequestParam(value = RestMapping.FILTER_CALL, required = false) String search){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n============", token.toString(), search);

        return modelMapper.map(
                // get only position for unit in user group
                positionRepository.findAll( Specifications.where(PositionForUnitInUserGroup.matchPositionForUnitInUserGroup(token.getGroup()))
                        .and(queryBuilder.build(search))),
                LIST_DTO
        );

        // return modelMapper.map(positionRepository.findAllByUnitIdAndUnitUnitToGroupsUserGroupIdIn(unitId, token.getGroup()), LIST_DTO);
    }

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


