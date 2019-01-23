package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.UserDao;
import com.msp.impulse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User findUserByNameAndPwd(String name, String password) {
        Query query=new Query(Criteria.where("account").is(name).and("password").is(password));
        return mongoTemplate.findOne(query,User.class);
    }

    @Override
    public User findOne(String id) {
        Query query=new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query,User.class);
    }
}
