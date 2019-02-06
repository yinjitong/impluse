package com.msp.impulse.dao.impl;

import com.msp.impulse.constants.Constants;
import com.msp.impulse.dao.DataManageDao;
import com.msp.impulse.entity.*;
import com.msp.impulse.query.PassQuery;
import com.msp.impulse.vo.HomePageDataVo;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DataManageDaoImpl implements DataManageDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public HomePageDataVo findHomeData() {

        HomePageDataVo homePageDataVo=new HomePageDataVo(0,0,0,0,0,0,0,null,null);
        //网关总格数
        Query queryGateway=new Query();
        Long count = mongoTemplate.count(queryGateway, Gateway.class);
        homePageDataVo.setGatewayNumber(count.intValue());
        //在线网关数
        Query queryGatewayOn =new Query();
        queryGatewayOn.addCriteria(Criteria.where("workStatus").is(Constants.SwitchStatus.ON.getValue()));
        Long countGatewayOn = mongoTemplate.count(queryGatewayOn, Gateway.class);
        homePageDataVo.setGatewayOnNumber(countGatewayOn.intValue());
        //离线网关数
        Query queryGatewayOff =new Query();
        queryGatewayOff.addCriteria(Criteria.where("workStatus").is(Constants.SwitchStatus.OFF.getValue()));
        Long countGatewayOff= mongoTemplate.count(queryGatewayOff, Gateway.class);
        homePageDataVo.setGatewayOffNumber(countGatewayOff.intValue());
        //网关个数
        Query quertCountSensor=new Query();
        Long countSensor = mongoTemplate.count(quertCountSensor, Sensor.class);
        homePageDataVo.setSensorNumber(countSensor.intValue());
        //在线传感器个数
        Query querySensorOn =new Query();
        querySensorOn.addCriteria(Criteria.where("workStatus").is(Constants.SwitchStatus.ON.getValue()));
        Long countSensorOn = mongoTemplate.count(querySensorOn, Sensor.class);
        homePageDataVo.setSensorOnNumber(countSensorOn.intValue());
        //离线传感器数
        Query querySensorOff =new Query();
        querySensorOff.addCriteria(Criteria.where("workStatus").is(Constants.SwitchStatus.OFF.getValue()));
        Long countSensorOff= mongoTemplate.count(querySensorOff, Sensor.class);
        homePageDataVo.setSensorOffNumber(countSensorOff.intValue());
        //报警个数
        Query queryCoubtAlarm=new Query();
        Long countAlarm= mongoTemplate.count(queryCoubtAlarm, Alarm.class);
        homePageDataVo.setAlarmNumber(countAlarm.intValue());
        //警报
        Query alarmQuery=new Query();
        mongoTemplate.find(alarmQuery,Alarm.class);
        //操作指令
        Query controllnstruQuery=new Query();
        mongoTemplate.find(controllnstruQuery, ControlInstru.class);

        return homePageDataVo;
    }

    /**
     * 查询所有网关的位置
     */
    @Override
    public Map<String, Object> findGatewayMap() {
        Query query=new Query();
        List<Gateway> gateways = mongoTemplate.find(query, Gateway.class);
        List<Position> positionGatewayList=new ArrayList<>();
        for (Gateway gateway:gateways) {
            Position position=new Position();
            position.setLatitude(gateway.getLatitude());
            position.setLongitude(gateway.getLongitude());
            positionGatewayList.add(position);
        }
        List<Sensor> sensorList = mongoTemplate.find(query, Sensor.class);
        List<Position> positionSensorList=new ArrayList<>();
        for (Sensor sensor:sensorList) {
            Position position=new Position();
            position.setLongitude(sensor.getLongitude());
            position.setLatitude(sensor.getLatitude());
            positionSensorList.add(position);
        }
        Map<String,Object> mapMap=new HashMap();
        mapMap.put("positionGatewayList",positionGatewayList);
        mapMap.put("positionSensorList",positionSensorList);
        return mapMap;
    }

    /**
     * 查询历史数据
     * @param passQuery
     * @return
     */
    @Override
    public List<Pass> findHistoryData(PassQuery passQuery) {
        Query query=new Query();
        List<Pass> passList = mongoTemplate.find(query, Pass.class);
        return passList;
    }
}
