package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.PhenomenonEntity;
import cz.hsrs.maplog.db.model.SensorEntity;
import cz.hsrs.maplog.db.queryspecification.specification.PhenomenonForUnitInUserGroup;
import cz.hsrs.maplog.db.repository.PhenomenonRepository;
import cz.hsrs.maplog.db.repository.SensorRepository;
import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Phenomenon;
import cz.hsrs.maplog.rest.dto.Position;
import cz.hsrs.maplog.rest.dto.receive.PhenomenonReceive;
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
 * Created by OK on 9/12/2017.
 */
@RestController
public class PhenomenonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhenomenonController.class);

    private static final String PREFIX_CONTROLLER = "/phenomenon";
    private final static Type LIST_DTO = new TypeToken<List<Phenomenon>>() {}.getType();

    @Autowired
    private PhenomenonRepository phenomenonRepository;

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getPhenomenon(@AuthenticationPrincipal UserToken token,
                                        @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                        Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                phenomenonRepository.findAll(
                        Specifications.where(PhenomenonForUnitInUserGroup.matchPhenomenonForUnitInUserGroup(token.getUserGroupEntity().getId()))
                                .and(queryBuilder.build(filter)),
                        pageable).getContent(),
                LIST_DTO
        );
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


