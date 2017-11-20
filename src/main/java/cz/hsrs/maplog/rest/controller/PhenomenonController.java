package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.PhenomenonEntity;
import cz.hsrs.maplog.db.repository.PhenomenonRepository;
import cz.hsrs.maplog.rest.dto.receive.PhenomenonReceive;
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
public class PhenomenonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhenomenonController.class);

    private static final String PREFIX_CONTROLLER = "/phenomenon";

    @Autowired
    private PhenomenonRepository phenomenonRepository;

    @Autowired
    private ModelMapper modelMapper;

    /***
     * /{client-id}/phenomenon/all
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_ALL, method = RequestMethod.GET)
    @ResponseBody
    public List<PhenomenonReceive> getPhenomenonAll(@PathVariable(RestMapping.CLIENT_ID) String clientId){

        LOGGER.info("> clientId {} ", clientId);
        return null;
    }

    /***
     * /{client-id}/phenomenon?unitId={unitId}
     * /{client-id}/phenomenon?phenomenonId={phenomenonId}&unitId={unitId}
     * /{client-id}/phenomenon?phenomenonName={phenomenonName}&unitId={unitId}
     * /{client-id}/phenomenon?sensortId={sensorId}
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<PhenomenonReceive> getPhenomenon(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                                 @RequestParam( value = RestMapping.UNIT_ID) String unitId,
                                                 @RequestParam(value = RestMapping.PHENOMENON_ID, required = false) String phenomenonId,
                                                 @RequestParam(value = RestMapping.PHENOMENON_NAME, required = false) String phenomenonName,
                                                 @RequestParam(value = RestMapping.SENSOR_ID, required = false) String sensorId){

        LOGGER.info("> clientId {}, unitId {}, phenomenonId {}, phenomenonName {} ", clientId, unitId, phenomenonId, phenomenonName);

        return null;
    }

    /***
     * /{client-id}/phenomenonReceive/insert
     *
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertPhenomenon(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                       @RequestBody PhenomenonReceive phenomenonReceive){

        LOGGER.info("> clientId {}, phenomenonId {} ", clientId, phenomenonReceive);

        // TODO here update sensor phenomenonId

        try {
            phenomenonRepository.save(modelMapper.map(phenomenonReceive, PhenomenonEntity.class));
            return RestMapping.STATUS_CREATED;
        } catch (MappingException e){
            return RestMapping.STATUS_BAD_REQUEST;
        }
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


