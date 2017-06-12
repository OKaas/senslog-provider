package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.rest.dto.Observation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by OK on 6/9/2017.
 */
@RestController
public class SensorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SensorController.class);

    /* --- REST calls --- */
    @RequestMapping(value = "/get-observation", method = RequestMethod.POST)
    public HttpStatus getObservationsBy(@RequestBody Observation observation) {

        LOGGER.info(" request {}", observation);

//        boolean inserted = false;
//        if (sensor_id == TrackIgnitionSolver.IGNITION_SENSOR_ID) {
//            TrackIgnitionSolver solver = new TrackIgnitionSolver(o);
//            solver.solve();
//            inserted = o.insertToDb();
//        } else {
//            inserted = o.insertToDb();
//        }

        return HttpStatus.OK;
    }
    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
}


