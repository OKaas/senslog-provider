package cz.senslog.rest.controller;

import cz.senslog.db.model.EnumItemEntity;
import cz.senslog.db.queryspecification.specification.EnumItemByName;
import cz.senslog.db.repository.AlertEventRepository;
import cz.senslog.db.repository.AlertRepository;
import cz.senslog.db.repository.EnumItemRepository;
import cz.senslog.db.repository.UnitRepository;
import cz.senslog.rest.RestMapping;
import cz.hsrs.maplog.rest.dto.AlertEvent;
import cz.hsrs.maplog.rest.dto.receive.AlertEventReceive;
import cz.senslog.security.UserToken;
import cz.senslog.util.QueryBuilder;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by OK on 1/21/2018.
 */
@RestController
public class AlertEventController implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertEventController.class);

    private final static String PREFIX_CONTROLLER = "/alertEvent";
    private final static Type LIST_DTO = new TypeToken<List<AlertEvent>>() {}.getType();

    private static EnumItemEntity DEFAULT_ALERT_EVENT;

    @Value("${enum.alert.event}")
    private String DEFAULT_ALERT_EVENT_NAME;

    @Autowired
    private AlertEventRepository alertEventRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private EnumItemRepository enumItemRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void afterPropertiesSet() throws Exception {
        DEFAULT_ALERT_EVENT = (EnumItemEntity) enumItemRepository.findOne(EnumItemByName.matchEnumItemByName(DEFAULT_ALERT_EVENT_NAME));
        if( DEFAULT_ALERT_EVENT == null ){
            LOGGER.error("Cannot find default enum item: {}", DEFAULT_ALERT_EVENT_NAME );
        }
    }

    /***
     * /alertEvent
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<AlertEvent> get(@AuthenticationPrincipal UserToken token,
                                @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                                Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(alertEventRepository.findAll(queryBuilder.build(filter), pageable).getContent(), LIST_DTO);
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


