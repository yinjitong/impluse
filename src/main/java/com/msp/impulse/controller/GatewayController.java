package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.query.GatewayQuery;
import com.msp.impulse.service.GatewayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gateway")
@Api(value = "网关管路", tags = "网关管理", description = "设备管理-网关管理")
public class GatewayController {
    private static Logger logger = LoggerFactory.getLogger(GatewayController.class);
    @Autowired
    private GatewayService gatewayService;

    @GetMapping("findSenorByCondition")
    @ApiOperation(value = "根据条件查询网关", notes = "根据条件查询网关", tags = "网关管理", httpMethod = "GET")
    public BaseResponse<List<Gateway>> findSenorByCondition(@RequestBody GatewayQuery gatewayQuery) {
        BaseResponse<List<Gateway>> response;
        try{
            response=gatewayService.findSenorByCondition(gatewayQuery);
        }catch(Exception e){
            logger.error(e.getMessage(),e);
            response=new BaseResponse<>();
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
        }
        return response;
    }

    @PostMapping("saveGateway")
    @ApiOperation(value = "新增修改网关信息", notes = "新增修改网关信息", tags = "网关管理", httpMethod = "POST")
    public BaseResponse addGateway(@RequestBody Gateway gateway) {
        BaseResponse response;
        try {
            response = gatewayService.addGateway(gateway);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @GetMapping("deleteGateway")
    @ApiOperation(value = "根据id删除网关信息", notes = "根据id删除网关信息", tags = "网关管理", httpMethod = "GET")
    public BaseResponse deleteGateway(String id){
        BaseResponse response;
        try {
            response = gatewayService.deleteGateway(id);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;

    }
}
