package com.msp.impulse.service;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.dao.AlarmDao;
import com.msp.impulse.entity.Alarm;
import com.msp.impulse.query.AlarmQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmService {
    @Autowired
    private AlarmDao alarmDao;

    public BaseResponse<Alarm> findAlarm(AlarmQuery alarmQuery) {
        BaseResponse<Alarm> response=new BaseResponse();
        alarmDao.findAlarm(alarmQuery);
        response.setResponseCode(ResponseCode.OK.getCode());
        response.setResponseMsg(ResponseCode.OK.getMessage());
        return response;
    }
}
