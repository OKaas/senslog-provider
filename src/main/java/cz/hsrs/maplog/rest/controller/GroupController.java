package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.repository.UserGroupRepository;
import cz.hsrs.maplog.rest.dto.UserGroup;
import cz.hsrs.maplog.util.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by OK on 7/3/2017.
 */
@RestController
public class GroupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

    private static final String PREFIX_CONTROLLER = "/group";

    @Autowired
    private Mapper objectMapper;

    // TODO for now without service layer -> controller use repository directly
    @Autowired
    private UserGroupRepository userGroupRepository;

    /* --- REST calls --- */
    @ResponseBody
    @RequestMapping(value = PREFIX_CONTROLLER+"/all", method = RequestMethod.GET)
    public List<UserGroup> getAllGroup(@RequestParam("userName") String userName) {
        LOGGER.info(" request:  {}", userName);
        return objectMapper.convertToDto(userGroupRepository.findByUsers_Name(userName));
    }

    @ResponseBody
    @RequestMapping(value = PREFIX_CONTROLLER+"/parent", method = RequestMethod.GET)
    public UserGroup getParentGroup(@RequestParam("nameGroup") String nameGroup) {

        LOGGER.info(" request: {}", nameGroup);
        return objectMapper.convertToDto(userGroupRepository.findParentUserGroupByName(nameGroup));
    }

    @ResponseBody
    @RequestMapping(value = PREFIX_CONTROLLER+"/child", method = RequestMethod.GET)
    public List<UserGroup> getChildGroup(@RequestParam("nameGroup") String nameGroup) {

        LOGGER.info(" request: {}", nameGroup);

        return objectMapper.convertToDto(userGroupRepository.findChildUserGroupByName(nameGroup));
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


