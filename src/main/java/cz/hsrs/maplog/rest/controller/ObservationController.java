package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.ObservationEntity;
import cz.hsrs.maplog.db.model.SensorEntity;
import cz.hsrs.maplog.db.queryspecification.specification.ObservationForUnitInUserGroup;
import cz.hsrs.maplog.db.queryspecification.specification.SensorById;
import cz.hsrs.maplog.db.queryspecification.specification.SensorForUnitInUserGroup;
import cz.hsrs.maplog.db.repository.ObservationRepository;
import cz.hsrs.maplog.db.repository.SensorRepository;
import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Observation;
import cz.hsrs.maplog.rest.dto.receive.ObservationReceive;
import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.QueryBuilder;
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
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class ObservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObservationController.class);

    private static final String PREFIX_CONTROLLER = "/observation";
    protected Type LIST_DTO = new TypeToken<List<Observation>>() {}.getType();

    @Autowired
    private ObservationRepository observationRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    /* --- REST calls --- */

    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Observation> get(@AuthenticationPrincipal UserToken token,
                                 @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                 Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                observationRepository.findAll(
                        Specifications.where(ObservationForUnitInUserGroup.matchObservationForUnitInUserGroup(token.getUserGroupEntity().getId()))
                                .and(queryBuilder.build(filter)),
                        pageable).getContent(),
                LIST_DTO
        );
    }

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


