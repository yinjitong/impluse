package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.UserDao;
import com.msp.impulse.entity.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public BaseResponse<List<User>> getAll() {
        BaseResponse<List<User>> response = new BaseResponse<>();
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        List<User> users = userDao.findAll();
        response.setData(users);
        return response;
    }

    public BaseResponse<User> addUser(User user) {
        BaseResponse<User> response = new BaseResponse<>();
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        //加密
        String pwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(pwd);

        userDao.save(user);
        response.setData(user);
        return response;
    }

    /**
     * 根据用户名密码查询用户表
     *
     * @param name
     * @param password
     * @return
     */
    public User findUserByNameAndPwd(String name, String password) {
        return userDao.findUserByNameAndPwd(name,password);
    }

    /**
     * 根据用户id查询用户表
     *
     * @param user
     * @return
     */
    public User findUser(User user) {
        return userDao.findOne(user.getId());
    }

    /**
     * 更新密码
     *
     * @param user
     * @param newPwd
     * @param oPwd
     */
    public BaseResponse modifyPwd(User user, String oPwd, String newPwd) {
        BaseResponse response = new BaseResponse<>();
        //参数是否为空
        if (StringUtils.isBlank(oPwd) || StringUtils.isBlank(newPwd)) {
            response.setResponseCode(ResponseCode.PARAMETER_ISNULL.getCode());
            response.setResponseMsg(ResponseCode.PARAMETER_ISNULL.getMessage());
            return response;
        }

        //判断用户是否登录
        if (null == user) {
            response.setResponseCode(ResponseCode.NOT_LOGIN.getCode());
            response.setResponseMsg(ResponseCode.NOT_LOGIN.getMessage());
            return response;
        }

        //判断原密码是否与数据库密码相符
        String oPassWord = DigestUtils.md5DigestAsHex(oPwd.getBytes());
        if (!oPassWord.equals(user.getPassword())) {
            response.setResponseCode(ResponseCode.OPWD_WRONG.getCode());
            response.setResponseMsg(ResponseCode.OPWD_WRONG.getMessage());
            return response;
        }

        //对新密码进行加密
        String newPassWord = DigestUtils.md5DigestAsHex(newPwd.getBytes());
        user.setPassword(newPassWord);
        userDao.save(user);

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());

        return response;
    }
}
