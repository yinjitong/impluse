package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.SystemUser;
import com.msp.impulse.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("userLogin")
@Api(value = "登录登出", tags = "登录登出", description = "登录登出")
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;

    @PostMapping("login")
    @ApiOperation(value = "用户登录", notes = "用户登录", tags = "登录登出", httpMethod = "POST")
    public BaseResponse login(@RequestBody SystemUser systemUser, HttpSession session) {

        BaseResponse response = new BaseResponse();
        try{
            response = loginService.findUserByNameAndPwd(systemUser.getAccount(), systemUser.getPassword());
            //记录登录状态
            session.setAttribute("loginUser", response.getData());
        }catch(Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("logout")
    @ApiOperation(value = "退出登录", notes = "退出登录", tags = "登录登出", httpMethod = "POST")
    public BaseResponse logout( HttpSession session) {

        BaseResponse response = new BaseResponse();
        //退出登录
        session.removeAttribute("loginUser");

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    @PostMapping("addSystemUser")
    @ApiOperation(value = "新增管理员", notes = "新增管理员", tags = "登录登出", httpMethod = "POST")
    public BaseResponse addSystemUser(@RequestBody  SystemUser systemUser) {
        BaseResponse response = new BaseResponse();
        try {
            response=loginService.addSystemUser(systemUser);
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
}
