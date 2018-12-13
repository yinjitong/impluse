package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.service.SensorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sensor")
@Api(value = "传感器接口", tags = "传感器接口", description = "传感器接口API")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping("addSensor")
    @ApiOperation(value="新增",notes = "新增传感器",tags="传感器操作",httpMethod = "POST")
    public BaseResponse addSensor(@RequestBody Sensor sensor){
        BaseResponse response;
        try{
           response=sensorService.addSensor(sensor);
        }catch(Exception e){
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("querySensorById")
    @ApiOperation(value="根据id查询",notes = "根据id返显传感器信息,用于编辑操作",tags="传感器操作",httpMethod = "POST")
    public BaseResponse<Sensor> querySensorById(String id){
        BaseResponse<Sensor> response;
        try{
            response=sensorService.querySensorById(id);
        }catch(Exception e){
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @GetMapping("searchSensor")
    @ApiOperation(value = "查询", notes = "查询传感器相关信息", tags = "传感器操作", httpMethod = "GET")
    public BaseResponse<List<Sensor>> querySensor(String sensorName, String gateWayName){
        BaseResponse<List<Sensor>> response;
        try{
            response=sensorService.queryBySensorAndGateway(sensorName,gateWayName);
        }catch(Exception e){
            e.printStackTrace();
            response = new BaseResponse<>();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());

        }
        return response;
    }

}
