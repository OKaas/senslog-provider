package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.repository.UserGroupRepository;
import cz.hsrs.maplog.rest.dto.UserGroup;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ModelMapper modelMapper;

    // TODO for now without service layer -> controller use repository directly
    @Autowired
    private UserGroupRepository userGroupRepository;

    // private final static Type groupType = new TypeToken<List<UserGroup>>() {}.getType();

    /* --- REST calls --- */
    @ResponseBody
    @RequestMapping(value = PATH_CLIENT_ID +PREFIX_CONTROLLER+"/all", method = RequestMethod.GET)
    public UserGroup getAllGroup(@PathVariable(CLIENT_ID) String clientId) {
        LOGGER.info(" request:  {}", clientId);
        return modelMapper.map(userGroupRepository.findByName(clientId), UserGroup.class);
    }

    @ResponseBody
    @RequestMapping(value = PATH_CLIENT_ID +PREFIX_CONTROLLER+"/parent", method = RequestMethod.GET)
    public UserGroup getParentGroup(@PathVariable String clientId) {

        return modelMapper.map(userGroupRepository.findParentGroupByName(clientId), UserGroup.class);
    }

    @ResponseBody
    @RequestMapping(value = PATH_CLIENT_ID +PREFIX_CONTROLLER+"/child", method = RequestMethod.GET)
    public List<UserGroup> getChildGroup(@PathVariable String clientId) {

        // return modelMapper.map(userGroupRepository.findChildGroupsByName(clientId), groupType);
        return null;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


