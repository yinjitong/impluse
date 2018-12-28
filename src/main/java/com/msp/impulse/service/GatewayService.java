package com.msp.impulse.service;

import com.bugull.mongo.BuguQuery;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.entity.Gateway;
import com.msp.impulse.query.GatewayQuery;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatewayService {

    @Autowired
    private GatewayDao gatewayDao;

    /**
     * 新增网关
     *
     * @param gateway
     * @return
     */
    public BaseResponse addGateway(Gateway gateway) {
        BaseResponse response = new BaseResponse<>();
        gatewayDao.save(gateway);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());

        return response;
    }

    /**
     * 根据条件分页查询网关信息
     * @param gatewayQuery
     * @return
     */
    public BaseResponse<List<Gateway>> findSenorByCondition(GatewayQuery gatewayQuery) {
        BaseResponse<List<Gateway>> response = new BaseResponse<>();
        BuguQuery<Gateway> buguQuery = gatewayDao.query();

        if (StringUtils.isNotBlank(gatewayQuery.getEquipmentName())) {
            buguQuery.is("equipmentName", gatewayQuery.getEquipmentName());
        }
        if (StringUtils.isNotBlank(gatewayQuery.getWorkModel())) {
            buguQuery.is("workModel", gatewayQuery.getWorkModel());
        }
        if (StringUtils.isNotBlank(gatewayQuery.getEquipmentType())) {
            buguQuery.is("equipmentType", gatewayQuery.getEquipmentType());
        }
        if (StringUtils.isNotBlank(gatewayQuery.getEquipmentModel())) {
            buguQuery.is("equipmentModel", gatewayQuery.getEquipmentModel());
        }
        if (StringUtils.isNotBlank(gatewayQuery.getWorkStatus())) {
            buguQuery.is("workStatus", gatewayQuery.getWorkStatus());
        }

        //最小页为第一页
        if (gatewayQuery.getPageNo()<1){
            gatewayQuery.setPageNo(1);
        }

        buguQuery.pageNumber(gatewayQuery.getPageNo());
        buguQuery.pageSize(gatewayQuery.getPageSize());
        response.setData(buguQuery.results());
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());

        return response;
    }

    /**
     * 根据id删除网关信息
     * @param id
     * @return
     */
    public BaseResponse deleteGateway(String id) {
        BaseResponse response = new BaseResponse();
        gatewayDao.findAndRemove(id);

        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());

        return response;
    }
}
