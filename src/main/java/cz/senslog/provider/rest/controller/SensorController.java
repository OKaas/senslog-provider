package cz.senslog.provider.rest.controller;

import cz.senslog.model.db.MetadataEntity;
import cz.senslog.model.db.PhenomenonEntity;
import cz.senslog.model.db.SensorEntity;
import cz.senslog.model.db.UnitEntity;
import cz.senslog.model.dto.Sensor;
import cz.senslog.model.dto.create.SensorCreate;
import cz.senslog.provider.db.queryspecification.specification.SensorSpecification;
import cz.senslog.provider.db.queryspecification.specification.UnitSpecification;
import cz.senslog.provider.db.repository.MetadataRepository;
import cz.senslog.provider.db.repository.PhenomenonRepository;
import cz.senslog.provider.db.repository.SensorRepository;
import cz.senslog.provider.db.repository.UnitRepository;
import cz.senslog.provider.rest.RestMapping;
import cz.senslog.provider.security.UserToken;
import cz.senslog.provider.util.QueryBuilder;
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
import java.util.NoSuchElementException;

/**
 * Created by OK on 6/9/2017.
 */
@RestController
public class SensorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SensorController.class);

    private static final String PREFIX_CONTROLLER = "/sensor";
    private final static Type LIST_DTO = new TypeToken<List<Sensor>>() {}.getType();
    private final static Type LIST_ENTITY = new TypeToken<List<SensorEntity>>() {}.getType();

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private PhenomenonRepository phenomenonRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private MetadataRepository metadataRepository;

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
    public List<Sensor> getSensor(@AuthenticationPrincipal UserToken token,
                                  @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                 Pageable pageable)
    {

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                sensorRepository.findAll(
                        Specifications.where(SensorSpecification.matchSensorForUnitInGroup(token.getUnitIds()))
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
                                   @RequestBody List<SensorCreate> sensorCreate){

        LOGGER.info("\n============\n > userToken: {} \n > DTO: {} \n============",
                token.toString(), sensorCreate);

        List<SensorEntity> sensorEntities = modelMapper.map(sensorCreate, LIST_ENTITY);

        List<UnitEntity> unitEntities = unitRepository.findAll(UnitSpecification.matchUnitInUnitGroup(token.getUnitIds()));

        for(SensorEntity sensorEntity : sensorEntities){
            SensorEntity toSave = sensorEntity.getId() != null ? sensorRepository.findOne(sensorEntity.getId()) : sensorEntity;

            if( toSave == null ){
                LOGGER.warn("Sensor id: \'{}\' does not exists!", sensorEntity.getId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            try {
                UnitEntity unitEntity = unitEntities.stream().filter(e -> e.getId().equals(sensorEntity.getUnit().getId())).findFirst().get();
                toSave.setUnit(unitEntity);
            } catch (NoSuchElementException e ){
                LOGGER.warn("Unit id: \'{}\' does not exists or it's assigned to Unit in other UnitGroup!", sensorEntity.getUnit().getId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            PhenomenonEntity phenomenonEntity = phenomenonRepository.findOne(sensorEntity.getPhenomenon().getId());
            if(phenomenonEntity == null ){
                LOGGER.warn("Phenomenon id: \'{}\' does not exists!", sensorEntity.getPhenomenon().getId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            MetadataEntity metadataEntity = metadataRepository.findOne(sensorEntity.getMetadata().getId());
            if(metadataEntity == null ){
                LOGGER.warn("Metadata id: \'{}\' does not exists!", sensorEntity.getMetadata().getId());
                return RestMapping.STATUS_BAD_REQUEST;
            }

            toSave.setDescription(sensorEntity.getDescription());
            toSave.setPhenomenon(phenomenonEntity);
            toSave.setMetadata(metadataEntity);

            sensorRepository.save(sensorEntity);
        }
        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
}


