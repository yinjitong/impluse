package com.msp.impulse.dao.impl;


import com.msp.impulse.dao.SensorDao;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.entity.Sensor;
import com.msp.impulse.query.SensorQuery;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.regex.Pattern;

@Repository
public class SensorDaoImpl implements SensorDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据id查找传感器
     * @param id
     * @return
     */
    @Override
    public Sensor findOne(String id) {
        Query query=new  Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query,Sensor.class);
    }

    /**
     * 保存传感器
     * @param sensor
     */
    @Override
    public void save(Sensor sensor) {
        mongoTemplate.save(sensor);
    }

    /**
     * 判断名称是否重复
     * @param name
     * @return
     */
    @Override
    public boolean findByName(String name) {
        Query query=new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Sensor> sensorList = mongoTemplate.find(query, Sensor.class);
        if(!sensorList.isEmpty()){
            return  true;
        }
        return false;
    }

    /**
     * 根据条件查询传感器
     * @param sensorQuery
     * @return
     */
    @Override
    public List<Sensor> queryBySensorAndGateway(SensorQuery sensorQuery) {

        Query query =new Query();
        if(StringUtils.isNotBlank(sensorQuery.getGatewayName())) {
            Pattern pattern = Pattern.compile("^" + sensorQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("gatewayName").regex(pattern));
        }
        if(StringUtils.isNotBlank(sensorQuery.getSensorName())) {
            Pattern pattern = Pattern.compile("^" + sensorQuery.getSensorName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("name").regex(pattern));
        }
        Pageable pageable=new PageRequest(sensorQuery.getPageNo(),sensorQuery.getPageSize());
        query.with(pageable);
        query.with(Sort.by(Sort.Order.desc("sensorNo")));
        List<Sensor> sensorList = mongoTemplate.find(query, Sensor.class);
        return sensorList;
    }
}
