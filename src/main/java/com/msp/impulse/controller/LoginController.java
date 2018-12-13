package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.User;
import com.msp.impulse.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("userLogin")
@Api(value = "登录登出接口", tags = "登录登出接口", description = "登录登出接口API")
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("login")
    @ApiOperation(value = "用户登录", notes = "用户登录", tags = "用户登录", httpMethod = "GET")
    public BaseResponse login(String account, String password, HttpSession session) {

        BaseResponse response = new BaseResponse();

        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = userService.findUserByNameAndPwd(account, pwd);
        if (null != user) {
            //记录登录状态
            session.setAttribute("loginUser", user);

            response.setResponseCode(ResponseCode.OK.getCode());
            response.setResponseMsg(ResponseCode.OK.getMessage());
            return response;
        }

        response.setResponseCode(ResponseCode.USERNAME_OR_PWD_WRONG.getCode());
        response.setResponseMsg(ResponseCode.USERNAME_OR_PWD_WRONG.getMessage());
        return response;
    }


    @RequestMapping("logout")
    @ApiOperation(value = "退出登录", notes = "退出登录", tags = "退出登录")
    public BaseResponse logout( HttpSession session) {

        BaseResponse response = new BaseResponse();
        //退出登录
        session.removeAttribute("loginUser");

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

}
