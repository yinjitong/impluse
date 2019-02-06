package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.ControlInstruDao;
import com.msp.impulse.entity.Alarm;
import com.msp.impulse.entity.ControlInstru;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.query.ControlInstruQuery;
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
public class ControlInstruDaoImpl implements ControlInstruDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void save(ControlInstru controlInstru) {
        mongoTemplate.save(controlInstru);
    }

    @Override
    public List<ControlInstru> findControlInstru(ControlInstruQuery controlInstruQuery) {
        Query query = new Query();
        if (StringUtils.isNotBlank(controlInstruQuery.getGatewayName())){
            Pattern pattern = Pattern.compile("^" + controlInstruQuery.getGatewayName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("gatewayName").regex(pattern));
        }
        //当前的开关状态
        if(StringUtils.isNotBlank(controlInstruQuery.getExecuteStatus())){
            query.addCriteria(Criteria.where("nowStatus").is(controlInstruQuery.getExecuteStatus()));
        }

        return null;
    }

    @Override
    public List<ControlInstru> getControlInstruList() {
        Query query=new Query();
        List<ControlInstru> controlInstruList = mongoTemplate.find(query, ControlInstru.class);
        return controlInstruList;
    }
}
