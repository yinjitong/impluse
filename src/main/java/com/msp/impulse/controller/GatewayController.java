package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.service.GatewayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gateway")
@Api(value = "网关接口", tags = "网关接口", description = "网关接口API")
public class GatewayController {

    @Autowired
    private GatewayService gatewayService;

    @GetMapping("findSenorByCondition")
    @ApiOperation(value = "根据条件查询网关", notes = "根据条件查询网关", tags = "网关操作", httpMethod = "GET")
    public BaseResponse<List<Gateway>> findSenorByCondition(@RequestBody Gateway gateway,Integer pageSize,Integer pageNumber) {
        BaseResponse<List<Gateway>> response;
        try{
            response=gatewayService.findSenorByCondition(gateway,pageSize,pageNumber);
        }catch(Exception e){
            response=new BaseResponse<>();
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
        }
        return response;
    }

    @PostMapping("saveGateway")
    @ApiOperation(value = "新增修改网关信息", notes = "新增修改网关信息", tags = "网关操作", httpMethod = "POST")
    public BaseResponse addGateway(@RequestBody Gateway gateway) {
        BaseResponse response;
        try {
            response = gatewayService.addGateway(gateway);
        } catch (Exception e) {
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @GetMapping("deleteGateway")
    @ApiOperation(value = "根据id删除网关信息", notes = "根据id删除网关信息", tags = "网关操作", httpMethod = "GET")
    public BaseResponse deleteGateway(String id){
        BaseResponse response;
        try {
            response = gatewayService.deleteGateway(id);
        } catch (Exception e) {
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;

    }
}
