package cz.senslog.provider.rest.controller;

import cz.senslog.model.dto.Metadata;
import cz.senslog.provider.db.queryspecification.specification.MetadataSpecification;
import cz.senslog.provider.db.repository.MetadataRepository;
import cz.senslog.provider.rest.RestMapping;
import cz.senslog.provider.security.UserToken;
import cz.senslog.provider.util.QueryBuilder;
import org.modelmapper.ModelMapper;
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

@RestController
public class MetadataController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventCodeController.class);

    private static final String PREFIX_CONTROLLER = "/metadata";
    private final static Type LIST_DTO = new TypeToken<List<Metadata>>() {}.getType();

    @Autowired
    private MetadataRepository metadataRepository;

    @Autowired
    private QueryBuilder queryBuilder;

    @Autowired
    private ModelMapper modelMapper;

    /***
     * /metadata
     *
     * @return
     */
    @RequestMapping(value = PREFIX_CONTROLLER, method = RequestMethod.GET)
    @ResponseBody
    public List<Metadata> get(@AuthenticationPrincipal UserToken token,
                           @RequestParam(value = RestMapping.FILTER_CALL, required = false) String filter,
                           Pageable pageable){

        LOGGER.info("\n============\n > userToken: {} \n > filter: {} \n > pageable: {} \n============",
                token.toString(), filter, pageable);

        return modelMapper.map(
                // get only position for unit in user group
                metadataRepository.findAll(
                        Specifications.where(queryBuilder.build(filter)),
                        pageable).getContent(),
                LIST_DTO
        );
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    /* --- Commons  --- */
}
