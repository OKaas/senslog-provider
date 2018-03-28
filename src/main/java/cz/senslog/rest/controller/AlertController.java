package cz.senslog.rest.controller;

import cz.senslog.db.model.AlertEntity;
import cz.senslog.db.repository.AlertRepository;
import cz.senslog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.Alert;
import cz.hsrs.maplog.rest.dto.receive.AlertReceive;
import cz.senslog.security.UserToken;
import cz.senslog.util.QueryBuilder;
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
public class AlertController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertController.class);

    private static final String PREFIX_CONTROLLER = "/alert";
    private final static Type LIST_DTO = new TypeToken<List<Alert>>() {}.getType();

    @Autowired
    private AlertRepository alertRepository;


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
                             @RequestBody List<AlertReceive> alerts){

        LOGGER.info("> client: {}, alertReceive {} ", token, alerts);

        for(AlertReceive alertReceive : alerts){
            alertRepository.save(modelMapper.map(alertReceive, AlertEntity.class));
        }

        return RestMapping.STATUS_CREATED;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


