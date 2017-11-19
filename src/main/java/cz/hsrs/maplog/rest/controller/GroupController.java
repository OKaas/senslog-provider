package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.repository.UserGroupRepository;
import cz.hsrs.maplog.rest.dto.UserGroup;
import cz.hsrs.maplog.security.UserToken;
import cz.hsrs.maplog.util.Mapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
@RestController
public class GroupController extends RestMapping {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

    private static final String PREFIX_CONTROLLER = "/group";

    @Autowired
    private Mapper modelMapper;

    @Autowired
    private UserGroupRepository userGroupRepository;

    private final static Type LIST_DTO = new TypeToken<List<UserGroup>>() {}.getType();

    /* --- REST calls --- */

    /**
     * http://localhost:8080/group/all
     *
     * @param details
     * @return
     */
    @ResponseBody
    @RequestMapping(value = PREFIX_CONTROLLER+"/all", method = RequestMethod.GET)
    public UserGroup getAllGroup(@AuthenticationPrincipal UserToken details){
        LOGGER.info(" request:  {}", details.toString());
        return modelMapper.map(details.getUserGroupEntity(), UserGroup.class);
    }

    /**
     * http://localhost:8080/group/parent
     *
     * @param details
     * @return
     */
    @ResponseBody
    @RequestMapping(value = PREFIX_CONTROLLER+"/parent", method = RequestMethod.GET)
    public UserGroup getParentGroup(@AuthenticationPrincipal UserToken details) {
        LOGGER.info(" request:  {}", details.toString());
        return modelMapper.map(details.getUserGroupEntity().getUserGroup(), UserGroup.class);
    }

    /**
     * http://localhost:8080/group/child
     *
     * @param details
     * @return
     */
    @ResponseBody
    @RequestMapping(value = PREFIX_CONTROLLER+"/child", method = RequestMethod.GET)
    public List<UserGroup> getChildGroup(@AuthenticationPrincipal UserToken details) {
        return modelMapper.map(userGroupRepository.getChildUserGroupById(details.getUserGroupEntity().getId()), LIST_DTO);
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


