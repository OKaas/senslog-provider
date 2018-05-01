package cz.senslog.provider.rest.controller;

import cz.senslog.model.dto.Phenomenon;
import cz.senslog.provider.db.repository.PhenomenonRepository;
import cz.senslog.provider.db.repository.SensorRepository;
import cz.senslog.provider.util.QueryBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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

//    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
//    @ResponseBody
//    public List<Phenomenon> getPhenomenon(@AuthenticationPrincipal UserToken token,
//                                        @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
//                                        Pageable pageable){
//
//        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
//                token.toString(), filter, pageable);
//
//        return modelMapper.map(
//                // get only position for unit in user group
//                phenomenonRepository.findAll(
//                        Specifications.where(PhenomenonForUnitInUserGroup.matchPhenomenonForUnitInUserGroup(token.getUserGroupEntity().getId()))
//                                .and(queryBuilder.build(filter)),
//                        pageable).getContent(),
//                LIST_DTO
//        );
//    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


