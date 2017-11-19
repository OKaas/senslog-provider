package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.entity.UnitEntity;
import cz.hsrs.maplog.db.entity.UnitToGroupEntity;
import cz.hsrs.maplog.db.repository.ObservationRepository;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.db.repository.UnitRepository;
import cz.hsrs.maplog.rest.dto.Unit;
import cz.hsrs.maplog.rest.dto.receive.UnitReceive;
import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private PositionRepository positionRepository;

    @Autowired
    private ObservationRepository observationRepository;


    private final static Type LIST_DTO = new TypeToken<List<Unit>>() {}.getType();

    private final static Type LIST_ENTITY = new TypeToken<List<UnitEntity>>() {}.getType();

    /* --- GET calls --- */

    /***
     * /unit/all
     * /unit/all?sort={static}
     * /unit/all?sort={mobile}
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_ALL, method = RequestMethod.GET)
    @ResponseBody
    public List<Unit> getAllUnit(@AuthenticationPrincipal UserToken details){

        LOGGER.info("> userToken: {}", details);

        return modelMapper.map(unitRepository.findAllByUnitToGroupsUserGroupId( details.getUserGroupEntity().getId() ), LIST_DTO);
    }

    /***
     * /unit?unitId={unitId}
     *
     * @param unitId
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public Unit getUnit(@AuthenticationPrincipal UserToken details,
                        @RequestParam(value = RestMapping.UNIT_ID) Long unitId ){
        LOGGER.info("> clientId {} , filter: {}", details.toString(), unitId);
        return modelMapper.map(unitRepository.findAllUnitByIdAndUnitToGroupsUserGroupIdIn( unitId, details.getGroup() ), Unit.class);
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

        for(UnitEntity usrGrpEntity : toSave){
            UnitToGroupEntity unitToGroupEntity = new UnitToGroupEntity();
            unitToGroupEntity.setUnit(usrGrpEntity);
            unitToGroupEntity.setUserGroup(details.getUserGroupEntity());

            usrGrpEntity.addUnitToGroup( unitToGroupEntity);
        }

        unitRepository.save( toSave );

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


