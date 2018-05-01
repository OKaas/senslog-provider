package cz.senslog.provider.rest.controller;

import cz.senslog.model.db.EventCodeEntity;
import cz.senslog.model.dto.Alert;
import cz.senslog.model.dto.create.EventCodeCreate;
import cz.senslog.provider.db.repository.EventCodeRepository;
import cz.senslog.provider.rest.RestMapping;
import cz.senslog.provider.security.UserToken;
import cz.senslog.provider.util.QueryBuilder;
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
 * Created by OK on 9/12/2017.
 */
@RestController
public class EventCodeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventCodeController.class);

    private static final String PREFIX_CONTROLLER = "/alert";
    private final static Type LIST_DTO = new TypeToken<List<Alert>>() {}.getType();

    @Autowired
    private EventCodeRepository alertRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    /***
     * /alert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Alert> get(@AuthenticationPrincipal UserToken token,
                                     @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                     Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(alertRepository.findAll(queryBuilder.build(filter), pageable).getContent(), LIST_DTO);
    }

    /***
     * /alert/insert
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER + RestMapping.PATH_INSERT, method = RequestMethod.POST)
    public HttpStatus insert(@AuthenticationPrincipal UserToken token,
                             @RequestBody List<EventCodeCreate> alerts){

        LOGGER.info("> client: {}, alertReceive {} ", token, alerts);

        for(EventCodeCreate alertReceive : alerts){
            alertRepository.save(modelMapper.map(alertReceive, EventCodeEntity.class));
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


