package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.model.SensorEntity;
import cz.hsrs.maplog.db.repository.SensorRepository;
import cz.hsrs.maplog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Position;
import cz.hsrs.maplog.rest.dto.Sensor;
import cz.hsrs.maplog.rest.dto.receive.SensorReceive;
import cz.hsrs.maplog.security.UserToken;
import org.modelmapper.MappingException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
                                         @RequestParam(value = RestMapping.FILTER_CALL, required = false) String search,
                                         Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), search, pageable);
        return null;
    }

    /***
     * /{client-id}/sensorReceive/insert
     * /{client-id}/sensorReceive/insert?unitId={unitId}
     *
     * @param clientId
     * @param unitId
     * @param sensorReceive - JSON with Id
     * @return
     */
    @RequestMapping(value = RestMapping.PATH_CLIENT_ID + PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insertSensor(@PathVariable(RestMapping.CLIENT_ID) String clientId,
                                   @RequestParam(value = RestMapping.UNIT_ID, required = false) String unitId,
                                   @RequestBody SensorReceive sensorReceive){

        LOGGER.info("> clientId {},  unitId {}, sensorReceive {}", clientId, unitId, sensorReceive);

        try {
            sensorRepository.save(modelMapper.map(sensorReceive, SensorEntity.class));
            return RestMapping.STATUS_CREATED;
        } catch (MappingException e){
            return RestMapping.STATUS_BAD_REQUEST;
        }
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
}


