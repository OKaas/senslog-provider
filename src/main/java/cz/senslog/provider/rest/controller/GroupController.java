package cz.senslog.provider.rest.controller;

import cz.senslog.provider.db.repository.UserGroupRepository;
import cz.senslog.provider.rest.RestMapping;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by OK on 7/3/2017.
 */
@RestController
public class GroupController extends RestMapping {

    private static final Logger LOGGER = LoggerFactory.getLogger(GroupController.class);

    private static final String PREFIX_CONTROLLER = "/group";

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserGroupRepository userGroupRepository;

    /* --- REST calls --- */

    /**
     * http://localhost:8080/group/all
     *
     * @param details
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = PREFIX_CONTROLLER+"/all", method = RequestMethod.GET)
//    public UserGroup getAllGroup(@AuthenticationPrincipal UserToken details){
//        LOGGER.info(" request:  {}", details.toString());
//        return modelMapper.map(details.getUserGroupEntity(), UserGroup.class);
//    }

    /**
     * http://localhost:8080/group/parent
     *
     * @param details
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = PREFIX_CONTROLLER+"/parent", method = RequestMethod.GET)
//    public UserGroup getParentGroup(@AuthenticationPrincipal UserToken details) {
//        LOGGER.info(" request:  {}", details.toString());
//        return modelMapper.map(details.getUserGroupEntity().getUserGroup(), UserGroup.class);
//    }

    /**
     * http://localhost:8080/group/child
     *
     * @param details
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = PREFIX_CONTROLLER+"/child", method = RequestMethod.GET)
//    public List<UserGroup> getChildGroup(@AuthenticationPrincipal UserToken details) {
//        return modelMapper.map(userGroupRepository.getChildUserGroupById(details.getUserGroupEntity().getId()), LIST_DTO);
//    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


