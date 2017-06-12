package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.rest.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by OK on 6/9/2017.
 */
@RestController
public class DataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

    /* --- REST calls --- */
    @RequestMapping(value = "/get-unitslist", method = RequestMethod.POST)
    public HttpStatus getUnitListBy(@RequestBody User user) {

        LOGGER.info(" request {}", user);

        return HttpStatus.OK;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
}


