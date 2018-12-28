package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.SystemUserDao;
import com.msp.impulse.entity.SystemUser;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    private SystemUserDao systemUserDao;

    /**
     * 更据用户名密码查找系统管理员
     * @param account
     * @param pwd
     * @return
     */
    public BaseResponse<SystemUser> findUserByNameAndPwd(String account, String pwd) {
        BaseResponse response=new BaseResponse();
        String encodePwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        List<SystemUser> results = systemUserDao.query().is("account", account).is("password", encodePwd).results();
        if(results.size()==0||results.get(0)==null){
            response.setResponseMsg(ResponseCode.USERNAME_OR_PWD_WRONG.getMessage());
            response.setResponseCode(ResponseCode.USERNAME_OR_PWD_WRONG.getCode());
            return response;
        }
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setData(results.get(0));
        return response;
    }

    /**
     * 新增管理员
     * @param systemUser
     * @return
     */
    public BaseResponse addSystemUser(SystemUser systemUser) {
        BaseResponse response=new BaseResponse();
        if(StringUtils.isBlank(systemUser.getAccount())){
            response.setResponseMsg(ResponseCode.USERNAME_NULL.getMessage());
            response.setResponseCode(ResponseCode.USERNAME_NULL.getCode());
            return response;
        }
        if(StringUtils.isBlank(systemUser.getPassword())){
            response.setResponseMsg(ResponseCode.PASSWORD_NULL.getMessage());
            response.setResponseCode(ResponseCode.PASSWORD_NULL.getCode());
            return response;
        }
        String password= DigestUtils.md5DigestAsHex(systemUser.getPassword().getBytes());
        systemUser.setPassword(password);
        systemUserDao.insert(systemUser);
        response.setResponseMsg(ResponseCode.OK.getMessage());
        response.setResponseCode(ResponseCode.OK.getCode());
        return response;
    }
}
