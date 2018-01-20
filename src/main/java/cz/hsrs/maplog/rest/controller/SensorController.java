package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.SensorEntity;
import cz.hsrs.maplog.db.model.UnitEntity;
import cz.hsrs.maplog.db.queryspecification.specification.SensorForUnitInUserGroup;
import cz.hsrs.maplog.db.queryspecification.specification.UnitById;
import cz.hsrs.maplog.db.queryspecification.specification.UnitInUserGroup;
import cz.hsrs.maplog.db.repository.PhenomenonRepository;
import cz.hsrs.maplog.db.repository.SensorRepository;
import cz.hsrs.maplog.db.repository.UnitRepository;
import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Sensor;
import cz.hsrs.maplog.rest.dto.receive.SensorReceive;
import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.QueryBuilder;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
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
 * Created by OK on 6/9/2017.
 */
@RestController
public class SensorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SensorController.class);

    private static final String PREFIX_CONTROLLER = "/sensor";
    private final static Type LIST_DTO = new TypeToken<List<Sensor>>() {}.getType();

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private PhenomenonRepository phenomenonRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    /* --- REST calls --- */
    /***
     * /sensor
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<SensorReceive> getSensor(@AuthenticationPrincipal UserToken token,
                                         @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                         Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                sensorRepository.findAll(
                        Specifications.where(SensorForUnitInUserGroup.matchSensorForUnitInUserGroup(token.getUserGroupEntity().getId()))
                                .and(queryBuilder.build(filter)),
                        pageable).getContent(),
                LIST_DTO
        );
    }

    /***
     * /sensor/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertSensor(@AuthenticationPrincipal UserToken token,
                                   @RequestBody SensorReceive sensorReceive){

        LOGGER.info("\n============\n > userToken: {} \n > DTO: {} \n============",
                token.toString(), sensorReceive);

        SensorEntity sensorEntity = modelMapper.map(sensorReceive, SensorEntity.class);

        if( sensorReceive.getUnitId() != null ){
            UnitEntity entity = (UnitEntity) unitRepository.findOne(
                                                Specifications.where(UnitById.matchUnitById(sensorReceive.getUnitId())).
                                                               and(UnitInUserGroup.matchUnitInUserGroup(token.getGroup())));

            // unitId does not exists or does not belongs to user's user group
            if( entity == null ){
                return RestMapping.STATUS_NOT_ACCETABLE;
            }

            // insert correct unit entity
            sensorEntity.setUnit( entity );
        }

        // save phenomenon if is specified
        if( sensorReceive.getPhenomenonId() != null ){
            sensorEntity.setPhenomenon(phenomenonRepository.findOne(sensorReceive.getPhenomenonId()));
        }

        try {
            sensorRepository.save(sensorEntity);
            return RestMapping.STATUS_CREATED;
        } catch (MappingException e){
            return RestMapping.STATUS_BAD_REQUEST;
        }
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
}


