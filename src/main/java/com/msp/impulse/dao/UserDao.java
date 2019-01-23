package com.msp.impulse.dao;

import com.msp.impulse.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    void save(User user);

    User findUserByNameAndPwd(String name, String password);

    User findOne(String id);
}
