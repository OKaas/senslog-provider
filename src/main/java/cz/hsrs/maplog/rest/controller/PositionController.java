package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.entity.PositionEntity;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.rest.dto.Position;
import cz.hsrs.maplog.util.Mapper;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by OK on 9/12/2017.
 */
@RestController
public class PositionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PositionController.class);

    private static final String PREFIX_CONTROLLER = "/position";

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ModelMapper modelMapper;

    /***
     * /{client-id}/position/insert
     *
     * @param clientId
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertPosition(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                     @RequestBody Position position){

        LOGGER.info("> clientId {}, position {}", clientId, position);

        try {

            positionRepository.save(modelMapper.map(position, PositionEntity.class));
            return RestMapping.STATUS_CREATED;
        } catch (MappingException e){
            return RestMapping.STATUS_BAD_REQUEST;
        }
    }

    /***
     * /{client-id}/position?positionId={positioId}&unitId={unitId}&sort={sort}
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getPositionByUnitPosition(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                              @RequestParam(value = RestMapping.UNIT_ID) String unitId,
                                              @RequestParam(value = RestMapping.POSITION_ID, required = false) String positionId,
                                              @RequestParam(value = RestMapping.SORT, required = false) String sort){

        LOGGER.info("> clientId {}, unitId {}, position {}, sort {}", clientId, unitId, positionId, sort);
        return null;
    }


    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


