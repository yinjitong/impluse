package com.msp.impulse.dao;

import com.msp.impulse.entity.Pass;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.query.PassQuery;
import com.msp.impulse.query.SensorQuery;

import java.util.List;

public interface SensorDao {
    Sensor findOne(String id);

    void save(Sensor sensor);

    boolean findByName(String name);

    List<Sensor> queryBySensorAndGateway(SensorQuery sensorQuery);

    Pass queryByPassNoAndGatewayName(PassQuery passQuery);
}
