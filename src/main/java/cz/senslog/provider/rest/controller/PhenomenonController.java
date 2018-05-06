package cz.senslog.provider.rest.controller;

import cz.senslog.model.db.PhenomenonEntity;
import cz.senslog.model.db.SensorEntity;
import cz.senslog.model.dto.Phenomenon;
import cz.senslog.model.dto.create.PhenomenonCreate;
import cz.senslog.provider.db.queryspecification.specification.PhenomenonSpecification;
import cz.senslog.provider.db.queryspecification.specification.SensorSpecification;
import cz.senslog.provider.db.repository.PhenomenonRepository;
import cz.senslog.provider.db.repository.SensorRepository;
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

/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class PhenomenonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhenomenonController.class);

    private static final String PREFIX_CONTROLLER = "/phenomenon";
    private final static Type LIST_DTO = new TypeToken<List<Phenomenon>>() {}.getType();
    private final static Type LIST_ENTITY = new TypeToken<List<PhenomenonEntity>>() {}.getType();

    @Autowired
    private PhenomenonRepository phenomenonRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    /* --- GET calls --- */

    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Phenomenon> getPhenomenon(@AuthenticationPrincipal UserToken token,
                                          @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                          Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                phenomenonRepository.findAll(
                        Specifications.where(PhenomenonSpecification.matchPhenomenonForUnitInGroup(token.getUnitGroup()))
                                      .and(queryBuilder.build(filter)),
                        pageable).getContent(),
                LIST_DTO
        );
    }

    /* --- POST calls --- */

    /***
     * /phenomenon/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insert(@AuthenticationPrincipal UserToken token,
                             @RequestBody List<PhenomenonCreate> phenomenons){

        LOGGER.info("> client: {}, phenomenon create {} ", token, phenomenons);

        List<PhenomenonEntity> phenomenonEntities = modelMapper.map(phenomenons, LIST_ENTITY);

        for(PhenomenonEntity phenomenon2Create : phenomenonEntities){

            PhenomenonEntity toSave = null;

            if (phenomenon2Create.getId() != null) {
                toSave = phenomenonRepository.findOne(phenomenon2Create.getId());

                if( toSave == null ){
                    LOGGER.warn("Phenomenon id: \'{}\' does not exists!", phenomenon2Create.getId());
                    return RestMapping.STATUS_BAD_REQUEST;
                }

                toSave.setDescription(phenomenon2Create.getDescription());
                toSave.setPhysicalUnit(phenomenon2Create.getPhysicalUnit());

                // get all sensors of all units in user unit group
                List<SensorEntity> entities = sensorRepository.findAll(Specifications.where(SensorSpecification.matchSensorForUnitInGroup(token.getUnitGroup())));

                for (PhenomenonCreate create : phenomenons) {
                    boolean hit = false;

                    for(Long sensorId : create.getSensors()){

                        for(SensorEntity sensorEntity : entities){
                            if(sensorEntity.getId().equals(sensorId)){
                                hit = true;
                                toSave.setSensors(phenomenon2Create.getSensors());
                            }
                        }

                        if (entities.stream().anyMatch( e -> e.getId().equals(sensorId)) ){
                            hit = true;
                        }

                        if( !hit ){
                            LOGGER.warn("Sensor id: \'{}\' does not exists or it's in other UnitGroup!", sensorId);
                            return RestMapping.STATUS_BAD_REQUEST;
                        }
                    }
                }


            } else {
                toSave = phenomenon2Create;
            }

            phenomenonRepository.save(toSave);
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


