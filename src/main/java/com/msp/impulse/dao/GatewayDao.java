package com.msp.impulse.dao;

import com.bugull.mongo.BuguDao;
import com.msp.impulse.entity.Gateway;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class GatewayDao extends BuguDao<Gateway> {
    public GatewayDao() {
        super(Gateway.class);
    }
}
