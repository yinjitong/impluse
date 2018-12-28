package com.msp.impulse.dao;

import com.bugull.mongo.BuguDao;
import com.msp.impulse.entity.SystemUser;
import org.springframework.stereotype.Repository;

@Repository
public class SystemUserDao  extends BuguDao<SystemUser> {
    public SystemUserDao() {
        super(SystemUser.class);
    }
}