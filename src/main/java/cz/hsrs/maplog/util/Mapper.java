package cz.hsrs.maplog.util;

import cz.hsrs.maplog.db.entity.*;
import cz.hsrs.maplog.rest.dto.Observation;
import cz.hsrs.maplog.rest.dto.Unit;
import cz.hsrs.maplog.rest.dto.UserGroup;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by OK on 7/4/2017.
 */
@Component
public class Mapper {

    @Autowired
    private ModelMapper modelMapper;

    /* --- Collaborates --- */

    /**
     * Observation conversion
     */
    public ObservationEntity toObservationEntity(Observation observation){
        SensorEntity sensorEntity = new SensorEntity();
        sensorEntity.setId(observation.getSensorId());

        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(observation.getUnitId());

        ObservationEntity entity = new ObservationEntity();
        entity.setObservedValue( observation.getValue() );
        entity.setSensor(sensorEntity);
        entity.setUnit(unitEntity);
        entity.setTimeReceived(observation.getTimestamp());

        return entity;
    }

    /**
     * Unit conversion
     */
    public List<Unit> toUnit(List<UnitEntity> entities){
        return entities.stream().map( e -> convertToUnit(e) ).collect(Collectors.toList());
    }

    public List<UnitEntity> toUnitEntity( List<Unit> entities ){
        return entities.stream().map( e -> convertToUnitEntity(e) ).collect(Collectors.toList());
    }

    private UnitEntity convertToUnitEntity(Unit unit){

//        UnitHolderEntity unitHolder = new UnitHolderEntity();
//
//        AlertEventEntity alertEvent = new AlertEventEntity();
//
////        List<ObservationEntity> observations;
////        List<UnitToGroupEntity> unitToGroups;
////        List<UnitPositionEntity> unitsPositions;
//
//        UnitEntity ret = new UnitEntity();
//        ret.setId(unit.getId());
//        ret.setDescription(unit.getDescription());
//        ret.setIsMobile(unit.getMobile());
//        ret.setUnitHolder(unitHolder);
//        ret.setAlertEvent(alertEvent);

        return modelMapper.map(unit, UnitEntity.class);
    }

    private Unit convertToUnit(UnitEntity entity){
        return modelMapper.map(entity, Unit.class);
    }

    /**
     * Group conversion
     */
    public UserGroup toUserGroup(UserGroupEntity group) {
        if( group != null ){
            return modelMapper.map(group, UserGroup.class);
        } else {
            return null;
        }
    }

    public List<UserGroup> toUserGroup(List<UserGroupEntity> group) {

        List<UserGroup> ret = new ArrayList<>();
        for( UserGroupEntity gr : group ){
            ret.add(toUserGroup(gr));
        }

        return ret;
    }

    /**
     * General
     */
    public Object convertToEntity(Object object, Class targetEntityClass){
        return modelMapper.map(object, targetEntityClass);
    }

    /* --- Getters / Setters --- */
    
    /* --- Commons  --- */
}


