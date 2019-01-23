package com.msp.impulse.service;

import com.msp.impulse.base.BaseRequest;
import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.ControlInstruDao;
import com.msp.impulse.entity.ControlInstru;
import com.msp.impulse.query.ControlInstruQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ControlInstruService {
    @Autowired
    private ControlInstruDao controlInstruDao;
    /**
     * 根据条件查询控制指令
     * @param controlInstruQuery
     * @return
     */
    public BaseResponse findControlInstru(ControlInstruQuery controlInstruQuery) {
        BaseResponse response=new BaseResponse();
        List<ControlInstru> controlInstruList= controlInstruDao.findControlInstru(controlInstruQuery);
        response.setData(controlInstruList);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
