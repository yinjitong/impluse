package com.msp.impulse.service;

import com.bugull.mongo.BuguQuery;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.GatewayDao;
import com.msp.impulse.entity.Gateway;
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
     * @param gateway
     * @param pageSize
     * @param pageNumber
     * @return
     */
    public BaseResponse<List<Gateway>> findSenorByCondition(Gateway gateway,Integer pageSize,Integer pageNumber) {
        BaseResponse<List<Gateway>> response = new BaseResponse<>();
        BuguQuery<Gateway> buguQuery = gatewayDao.query();

        if (StringUtils.isNotBlank(gateway.getEquipmentName())) {
            buguQuery.is("equipmentName", gateway.getEquipmentName());
        }
        if (StringUtils.isNotBlank(gateway.getWorkModel())) {
            buguQuery.is("workModel", gateway.getWorkModel());
        }

        if (StringUtils.isNotBlank(gateway.getEquipmentType())) {
            buguQuery.is("equipmentType", gateway.getEquipmentType());
        }
        if (StringUtils.isNotBlank(gateway.getEquipmentModel())) {
            buguQuery.is("equipmentModel", gateway.getEquipmentModel());
        }

        if (StringUtils.isNotBlank(gateway.getWorkStatus())) {
            buguQuery.is("workStatus", gateway.getWorkStatus());
        }

        //最小页为第一页
        if (pageNumber<1){
            pageNumber=1;
        }

        buguQuery.pageNumber(pageNumber);
        buguQuery.pageSize(pageSize);
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
