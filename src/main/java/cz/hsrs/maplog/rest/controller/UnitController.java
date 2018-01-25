package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.UnitEntity;
import cz.hsrs.maplog.db.model.UnitToGroupEntity;
import cz.hsrs.maplog.db.queryspecification.specification.UnitInUserGroup;
import cz.hsrs.maplog.db.repository.ObservationRepository;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.db.repository.UnitRepository;
import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Unit;
import cz.hsrs.maplog.rest.dto.receive.UnitReceive;
import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.Mapper;
import cz.hsrs.maplog.util.QueryBuilder;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by OK on 7/4/2017.
 */
@RestController
public class UnitController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnitController.class);

    private static final String PREFIX_CONTROLLER = "/unit";

    @Autowired
    private Mapper modelMapper;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ObservationRepository observationRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    private final static Type LIST_DTO = new TypeToken<List<Unit>>() {}.getType();

    private final static Type LIST_ENTITY = new TypeToken<List<UnitEntity>>() {}.getType();

    /* --- GET calls --- */


    /***
     * /unit
     * /unit?filter=isMobile:[true:false]
     * /unit?filter=id:<number>
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Unit> getUnit(@AuthenticationPrincipal UserToken token,
                              @RequestParam(value = RestMapping.FILTER_CALL, required = false) String search,
                              Pageable pageable){
        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n============", token.toString(), search);

        return modelMapper.map(
                // get only user group unit and filter them afterwards
                unitRepository.findAll( Specifications.where(UnitInUserGroup.matchUnitInUserGroup(token.getGroup()))
                                        .and(queryBuilder.build(search)), pageable).getContent(),
                LIST_DTO
        );
    }

    /* --- POST CALLS --- */

    /***
     * /unit/insert
     *
     * @param unit
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertUnit(@AuthenticationPrincipal UserToken token,
                                 @RequestBody List<UnitReceive> unit){

        LOGGER.info("> request {}, units {}", token.toString(), unit);

        List<UnitEntity> unitsToSave = modelMapper.map(unit, LIST_ENTITY);

        for(UnitEntity update : unitsToSave){

            UnitEntity unit2Save = null;
            UnitToGroupEntity unitToGroupEntity = null;

            // get JPA managed entity if exists
            if( update.getId() != null ){
                unit2Save = unitRepository.findOne( update.getId() );

                // TODO: dummy mapping between DTO and Entities :(
                // update entity
                unit2Save.setIsMobile(update.getIsMobile());
                unit2Save.setDescription(update.getDescription());

                List<UnitToGroupEntity> originalUnitToGroup = unit2Save.getUnitToGroups();

                // hit unit2group entity to change user group
                for(UnitToGroupEntity unit2GroupEntity : originalUnitToGroup){
                    if(unit2GroupEntity.getUnit().getId().equals(update.getId())){
                        unitToGroupEntity = unit2GroupEntity;
                        break;
                    }
                }
            } else {
                unit2Save = update;
            }

            // this unit2group connection is not in DB
            if( unitToGroupEntity == null ){
                unitToGroupEntity = new UnitToGroupEntity();
            }

            unitToGroupEntity.setUnit(update);
            unitToGroupEntity.setUserGroup(token.getUserGroupEntity());

            unit2Save.addUnitToGroup(unitToGroupEntity);

            update.addUnitToGroup(unitToGroupEntity);
        }

        unitRepository.save( unitsToSave );

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


