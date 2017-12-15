package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.UnitEntity;
import cz.hsrs.maplog.db.model.UnitToGroupEntity;
import cz.hsrs.maplog.db.queryspecification.EntityQueryable;
import cz.hsrs.maplog.db.queryspecification.UnitInUserGroup;
import cz.hsrs.maplog.db.repository.ObservationRepository;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.db.repository.UnitRepository;
import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Unit;
import cz.hsrs.maplog.rest.dto.UnitToGroup;
import cz.hsrs.maplog.rest.dto.receive.UnitReceive;
import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.Mapper;
import cz.hsrs.maplog.util.QueryBuilder;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    public List<Unit> getUnit(@AuthenticationPrincipal UserToken details,
                              @RequestParam(value = RestMapping.FILTER_CALL, required = false) String search){
        LOGGER.info("============\n > userToken: {} \n > filter: {} \n============", details.toString(), search);

        return modelMapper.map(
                // get only user group unit and filter them afterwards
                unitRepository.findAll( Specifications.where(UnitInUserGroup.matchUnitInUserGroup(details.getGroup()))
                                        .and(queryBuilder.build(search))),
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
    public HttpStatus insertUnit(@AuthenticationPrincipal UserToken details,
                                 @RequestBody List<UnitReceive> unit){

        LOGGER.info("> request {}, units {}", details.toString(), unit);

        List<UnitEntity> toSave = modelMapper.map(unit, LIST_ENTITY );

        // get jpa managed entity
        toSave.stream().filter( e -> e.getId() != null ).forEach( e -> e = unitRepository.findOne( e.getId() ));

        for(UnitEntity update : toSave){

            // get JPA managed entity if exists
            UnitEntity original = unitRepository.findOne( update.getId() );

            // TODO: dummy mapping between DTO and Entities :(
            if( original != null ){
                // update entity
                original.setIsMobile(update.getIsMobile());
                original.setDescription(update.getDescription());

                List<UnitToGroupEntity> toRemove = new ArrayList<>();

                // update unit to group child entities
                for (Iterator iteratorOriginal = original.getUnitToGroups().iterator(); iteratorOriginal.hasNext();) {

                    UnitToGroupEntity originalUnitToGroup = (UnitToGroupEntity) iteratorOriginal.next();

                    for(Iterator iteratorUpdate = update.getUnitToGroups().iterator(); iteratorUpdate.hasNext();) {

                        UnitToGroupEntity updateUnitToGroup = (UnitToGroupEntity) iteratorUpdate.next();

                        // same connection between unity and user group
//                        if( originalUnitToGroup.getUnit().equals(updateUnitToGroup.getUnit())){
//                            originalUnitToGroup.setUserGroup(updateUnitToGroup.getUserGroup());
//                        } else {
//                            // if not create new one
//                            unitToGroupEntity.setUnit(update);
//                            unitToGroupEntity.setUserGroup(details.getUserGroupEntity());
//
//                            update.addUnitToGroup( unitToGroupEntity);
//                        }
                    }
                }
            }
        }

        unitRepository.save( toSave );

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


