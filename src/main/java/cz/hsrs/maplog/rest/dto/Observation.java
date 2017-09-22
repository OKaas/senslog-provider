package cz.hsrs.maplog.rest.dto;

import cz.hsrs.maplog.db.entity.PositionEntity;
import cz.hsrs.maplog.db.entity.SensorEntity;
import cz.hsrs.maplog.db.entity.UnitEntity;

import java.sql.Timestamp;


/**
 * Created by OK on 6/9/2017.
 */
public class Observation {

    private Long id;
    private Double observedValue;
    private long unitId;
    private long sensorId;
    // TODO: should be defined in properties or system env
    private Timestamp timeReceived;

    private SensorEntity sensor;
    private UnitEntity unit;
    private PositionEntity positionEntity;

    public Observation() {
    }

    /* --- Collaborates --- */

    /* --- Getters / Setters --- */

    public Double getValue() {
        return observedValue;
    }

    public void setValue(double value) {
        this.observedValue = value;
    }

    public long getUnitId() {
        return unitId;
    }

    public void setUnitId(long unit) {
        this.unitId = unit;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public Timestamp getTimestamp() {
        return timeReceived;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timeReceived = timestamp;
    }

    /* --- Commons  --- */

    @Override
    public String toString() {
        return "ObservationEntity{" +
                "value=" + observedValue +
                ", unitId=" + unitId +
                ", sensorId=" + sensorId +
                ", timestamp=" + timeReceived +
                '}';
    }
}


