package com.msp.impulse.dao;

import com.bugull.mongo.BuguDao;
import com.msp.impulse.entity.Sensor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class SensorDao  extends BuguDao<Sensor> {
    public SensorDao() {
        super(Sensor.class);
    }
}
