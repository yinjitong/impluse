package com.msp.impulse.dao.impl;

import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.query.GatewayQuery;
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
public class GatewayDaoImpl implements GatewayDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Gateway save(Gateway gateway) {
        mongoTemplate.save(gateway);
        return gateway;
    }

    @Override
    public void findAndRemove(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.findAndRemove(query, Gateway.class);
    }

    @Override
    public List<Gateway> findGatewayByCondition(GatewayQuery gatewayQuery) {
        Query query = new Query();

        if (StringUtils.isNotBlank(gatewayQuery.getEquipmentName())) {
            Pattern pattern = Pattern.compile("^" + gatewayQuery.getEquipmentName() + ".*$", Pattern.CASE_INSENSITIVE);
            query.addCriteria(Criteria.where("equipmentName").regex(pattern));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getWorkModel())) {
            query.addCriteria(Criteria.where("workModel").is(gatewayQuery.getWorkModel()));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getEquipmentType())) {
            query.addCriteria(Criteria.where("equipmentType").is(gatewayQuery.getEquipmentType()));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getEquipmentModel())) {
            query.addCriteria(Criteria.where("equipmentModel").is(gatewayQuery.getEquipmentModel()));
        }
        if (StringUtils.isNotBlank(gatewayQuery.getWorkStatus())) {
            query.addCriteria(Criteria.where("workStatus").is(gatewayQuery.getWorkStatus()));
        }
        Pageable pageable=new PageRequest(gatewayQuery.getPageNo(),gatewayQuery.getPageSize());
        query.with(pageable);
        query.with(Sort.by(Sort.Order.desc("equipmentNo")));
        List<Gateway> gateways = mongoTemplate.find(query, Gateway.class);

        return gateways;

    }

    @Override
    public boolean findByName(String gatewayName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("equipmentName").is(gatewayName));
        List<Gateway> gateways = mongoTemplate.find(query, Gateway.class);
        if (gateways.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Gateway findGatewayById(String id) {
        Query query=new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query,Gateway.class);
    }
}
