package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.repository.GroupsRepository;
import cz.hsrs.maplog.rest.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by OK on 7/3/2017.
 */
@RestController
public class GroupController {

    private static final String PREFIX_CONTROLLER = "/group";

    private static final Logger LOGGER = LoggerFactory.getLogger(FeederController.class);


    @Autowired
    private GroupsRepository groupsRepository;

    /* --- REST calls --- */
    @RequestMapping(value = "/group/all", method = RequestMethod.GET)
    public HttpStatus getAllGroup(@RequestParam("userName") String userName) {

        LOGGER.info(" request {}", userName);

        // TODO: create some automatic transform (some ObjectMapper)
        groupsRepository.findBySystemUsers_UserName(userName);

        return HttpStatus.OK;
    }

    @RequestMapping(value = PREFIX_CONTROLLER+"/parent", method = RequestMethod.GET)
    public HttpStatus getParentGroup(@RequestParam("userName") String userName) {

        LOGGER.info(" request {}", userName);

        // TODO: create some automatic transform (some ObjectMapper)
        groupsRepository.findBySystemUsers_UserName(userName);

        return HttpStatus.OK;
    }

    @RequestMapping(value = PREFIX_CONTROLLER+"/child", method = RequestMethod.GET)
    public HttpStatus getChildGroup(@RequestParam("userName") String userName) {

        LOGGER.info(" request {}", userName);

        // TODO: create some automatic transform (some ObjectMapper)
        groupsRepository.findBySystemUsers_UserName(userName);

        return HttpStatus.OK;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


