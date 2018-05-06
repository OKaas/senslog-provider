package cz.senslog.provider.rest.controller;

import cz.senslog.model.db.UnitEntity;
import cz.senslog.model.db.UnitGroupEntity;
import cz.senslog.model.dto.Unit;
import cz.senslog.model.dto.create.UnitCreate;
import cz.senslog.provider.db.queryspecification.specification.UnitById;
import cz.senslog.provider.db.repository.UnitGroupRepository;
import cz.senslog.provider.db.repository.UnitRepository;
import cz.senslog.provider.rest.RestMapping;
import cz.senslog.provider.security.UserToken;
import cz.senslog.provider.util.Mapper;
import cz.senslog.provider.util.QueryBuilder;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private Mapper modelMapper;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private UnitGroupRepository unitGroupRepository;

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
                              @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                              Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n============", token.toString(), filter);

        return modelMapper.map(
                // get only user group unit and filter them afterwards
                unitRepository.findAll(
                        Specifications.where(UnitById.matchUnitByIds(token.getUnitGroup()))
                                      .and(queryBuilder.build(filter)), pageable).getContent(),
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
                                 @RequestBody List<UnitCreate> unit){

        LOGGER.info("> request {}, units {}", token.toString(), unit);

        List<UnitEntity> unitsToSave = modelMapper.map(unit, LIST_ENTITY);

        for(UnitEntity update : unitsToSave){

            UnitEntity unit2Save = null;

            // get JPA managed entity if exists
            if( update.getId() != null ){
                unit2Save = unitRepository.findOne( update.getId() );

                if( unit2Save == null ){
                    LOGGER.warn("Unit id: \'{}\' does not exists!", update.getId());
                    return RestMapping.STATUS_BAD_REQUEST;
                }

            } else {
                unit2Save = update;
            }

            UnitGroupEntity unitGroupEntity = unitGroupRepository.findOne( update.getUnitGroup().getId() );
            if( unitGroupEntity == null ) {
                LOGGER.warn("UnitGroup id: \'{}\' does not exists!", update.getUnitGroup().getId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            // user try to assign unit to another unit group where it has not permission
            if( !token.getUnitGroup().contains(unitGroupEntity.getId()) ){
                LOGGER.warn("Current user  \'{}\' does not have permission to unit group \'{}\'!", token, unitGroupEntity.getId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            // TODO: dummy mapping between DTO and Entities :(
            // update entity
            unit2Save.setDescription(update.getDescription());
            unit2Save.setUnitGroup(unitGroupEntity);
        }

        unitRepository.save( unitsToSave );

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


