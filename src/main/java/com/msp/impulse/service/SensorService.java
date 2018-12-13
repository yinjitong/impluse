package com.msp.impulse.service;

import com.bugull.mongo.BuguQuery;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.SensorDao;
import com.msp.impulse.entity.Sensor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {
    @Autowired
    private SensorDao sensorDao;

    /**
     * 新增传感器
     * @param sensor
     * @return
     */
    public BaseResponse addSensor(Sensor sensor) {
        BaseResponse response=new BaseResponse();
        sensorDao.save(sensor);

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     * 根据传感器名称和网关查询传感器信息
     * @param sensorName
     * @param gateWayName
     * @return
     */
    public BaseResponse<List<Sensor>> queryBySensorAndGateway(String sensorName, String gateWayName) {

        BaseResponse<List<Sensor>> response=new BaseResponse<>();
        BuguQuery<Sensor> query = sensorDao.query();
        if(StringUtils.isNotBlank(sensorName)){
            query.is("name", sensorName);
        }
        response.setData(query.results());
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }

    /**
     *根据id查询传感器
     * @param id
     * @return
     */
    public BaseResponse<Sensor> querySensorById(String id) {
        BaseResponse<Sensor> response=new BaseResponse<>();
        Sensor sensor = sensorDao.findOne(id);
        response.setData(sensor);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
