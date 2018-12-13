package com.msp.impulse.dao;

import com.bugull.mongo.BuguDao;
import com.msp.impulse.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserDao extends BuguDao<User> {
    public UserDao() {
        super(User.class);
    }
}
