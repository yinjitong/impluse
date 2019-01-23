package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.SystemUserDao;
import com.msp.impulse.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SystemUserDaoImpl implements SystemUserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public SystemUser findByAccountAndPwd(String account, String encodePwd) {
        Query query=new Query(Criteria.where("account").is(account).and("password").is(encodePwd));
        SystemUser systemUser = mongoTemplate.findOne(query, SystemUser.class);
        return systemUser;
    }

    @Override
    public void save(SystemUser systemUser) {
        mongoTemplate.save(systemUser);
    }
}
