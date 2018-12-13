package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.User;
import com.msp.impulse.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("user")
@Api(value="用户接口", tags = "用户接口", description="用户接口API")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("getAll")
    @ApiOperation(value = "获取所有用户", notes = "获取所有用户", tags = "获取所有用户",httpMethod = "POST")
    public BaseResponse<List<User>> getAll(){
        BaseResponse<List<User>> response;
        try{
            response = userService.getAll();
        }catch (Exception e){
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }finally {

        }
        return response;
    }


    @PostMapping("addUser")
    @ApiOperation(value = "添加用户", notes = "新增用户", tags = "用户操作",httpMethod = "POST")
    public BaseResponse<User> addUser(@RequestBody User user){
        BaseResponse<User> response;
        try{
            response = userService.addUser(user);
        }catch (Exception e){
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }finally {

        }
        return response;
    }

    @GetMapping("modifyPwd")
    @ApiOperation(value = "修改密码", notes = "修改密码", tags = "修改密码",httpMethod = "GET")
    public BaseResponse modifyPwd(String oPwd, String newPwd, HttpSession session){
        BaseResponse response = new BaseResponse<>();
        try {
            User user = (User) session.getAttribute("loginUser");
            //更新密码
           response= userService.modifyPwd(user,oPwd,newPwd);

        }catch(Exception e){
            e.printStackTrace();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }
}
