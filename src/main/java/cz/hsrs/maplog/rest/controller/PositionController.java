package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.PositionEntity;
import cz.hsrs.maplog.db.model.UnitEntity;
import cz.hsrs.maplog.db.queryspecification.specification.PositionForUnitInUserGroup;
import cz.hsrs.maplog.db.queryspecification.specification.UnitInSet;
import cz.hsrs.maplog.db.queryspecification.specification.UnitInUserGroup;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.db.repository.UnitRepository;
import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Position;
//import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.rest.dto.receive.PositionReceive;
import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.Mapper;
import cz.hsrs.maplog.util.QueryBuilder;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specifications;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

import static cz.hsrs.maplog.db.queryspecification.specification.UnitInSet.matchUnitInSet;

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
    private UnitRepository unitRepository;

    @Autowired
    private Mapper modelMapper;

    /* --- GET calls --- */

    /***

     * /position?unitId=
     *
     * http://localhost:8080/position
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getPosition(@AuthenticationPrincipal UserToken token,
                                      @RequestParam(value = RestMapping.FILTER_CALL, required = false) String search,
                                      Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), search, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                positionRepository.findAll(
                        Specifications.where(PositionForUnitInUserGroup.matchPositionForUnitInUserGroup(token.getGroup()))
                                      .and(queryBuilder.build(search)),
                        pageable).getContent(),
                LIST_DTO
        );
    }

    /* --- POST CALLS --- */

    /***
     * position/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertPosition(@AuthenticationPrincipal UserToken token,
                                     @RequestBody PositionReceive unitPositionReceive){

        LOGGER.info("> clientId {}, unitPositionReceive {}", unitPositionReceive);

        // Get all units in user group
        List<UnitEntity> unitEntities = unitRepository.findAll(
                        Specifications.where(UnitInUserGroup.matchUnitInUserGroup(token.getGroup()))
                                .and( UnitInSet.matchUnitInSet(token.getUserGroupEntity().getId()))
        );

        // save only if unit is attached to UserToken's user group
        if( unitEntities.stream().anyMatch( e -> e.getId().equals(unitPositionReceive.getUnitId())) ){
            positionRepository.save(modelMapper.map(unitPositionReceive, PositionEntity.class));
            return RestMapping.STATUS_CREATED;
        } else {
            LOGGER.info("User does not have unit: {}", unitPositionReceive.getUnitId());
            return RestMapping.STATUS_NOT_ACCETABLE;
        }
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


