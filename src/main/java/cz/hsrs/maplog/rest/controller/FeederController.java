package cz.hsrs.maplog.rest.controller;

import cz.hsrs.maplog.db.entity.AlertEntity;
import cz.hsrs.maplog.db.entity.ObservationEntity;
import cz.hsrs.maplog.db.entity.PositionEntity;
import cz.hsrs.maplog.db.repository.AlertRepository;
import cz.hsrs.maplog.db.repository.ObservationRepository;
import cz.hsrs.maplog.db.repository.PositionRepository;
import cz.hsrs.maplog.rest.dto.Alert;
import cz.hsrs.maplog.rest.dto.Observation;
import cz.hsrs.maplog.rest.dto.Position;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by OK on 6/9/2017.
 */
@RestController
public class FeederController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeederController.class);

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private ObservationRepository observationRepository;

    @Autowired
    private AlertRepository alertRepository;

    /* --- REST calls --- */
    @RequestMapping(value = "/insert-observation", method = RequestMethod.POST)
    public HttpStatus insertObservation(@RequestBody Observation observation) {

        LOGGER.info(" request {}", observation.toString());

        // TODO: create some automatic transform (some ObjectMapper)
//        ObservationEntity entity = new ObservationEntity();
//        entity.setDate(observation.getDate());
//        entity.setSensorId(observation.getSensorId());
//        entity.setUnitId(observation.getUnitId());
//        entity.setValue(observation.getValue());

//        observationRepository.save(entity);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "/insert-position", method = RequestMethod.POST)
    public HttpStatus insertPosition(@RequestBody Position position) {

        LOGGER.info(" request {}", position.toString());

        // TODO: create some automatic transform (some ObjectMapper)
        PositionEntity entity = new PositionEntity();
        entity.setAlt(position.getAlt());

        entity.setDate(position.getDate());
        entity.setDop(position.getDop());
        entity.setLat(position.getLat());
        entity.setLon(position.getLon());
        entity.setSpeed(position.getSpeed());
        entity.setUnitId(position.getUnitId());

        positionRepository.save(entity);

        return HttpStatus.OK;
    }

    @RequestMapping(value = "/insert-alert", method = RequestMethod.POST)
    public HttpStatus insertAlertEvent(@RequestBody Alert alert) {

        LOGGER.info(" request {}", alert.toString());

        // TODO: create some automatic transform (some ObjectMapper)
        AlertEntity entity = new AlertEntity();
//        entity.setAlertId(alert.getAlertId());
//        entity.setDate(alert.getDate());
//        entity.setUnitId(alert.getUnitId());

        alertRepository.save(entity);

        return HttpStatus.OK;
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */
}


