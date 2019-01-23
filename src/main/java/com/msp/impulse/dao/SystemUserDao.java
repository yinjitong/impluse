package com.msp.impulse.dao;

import com.msp.impulse.entity.SystemUser;

import java.util.List;

public interface SystemUserDao {
   SystemUser findByAccountAndPwd(String account, String encodePwd);

    void save(SystemUser systemUser);
}