package cz.senslog.rest.controller;

import cz.senslog.db.queryspecification.specification.PositionForUnitInUserGroup;
import cz.senslog.db.repository.PositionRepository;
import cz.senslog.db.repository.UnitRepository;
import cz.senslog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Position;
import cz.hsrs.maplog.rest.dto.receive.PositionReceive;
import cz.senslog.security.UserToken;
import cz.senslog.util.Mapper;
import cz.senslog.util.QueryBuilder;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

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
                                      @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                      Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                positionRepository.findAll(
                        Specifications.where(PositionForUnitInUserGroup.matchPositionForUnitInUserGroup(token.getUserGroupEntity().getId()))
                                      .and(queryBuilder.build(filter)),
                        pageable).getContent(),
                LIST_DTO
        );
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


