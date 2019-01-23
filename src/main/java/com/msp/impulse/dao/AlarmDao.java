package com.msp.impulse.dao;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.entity.Alarm;
import com.msp.impulse.query.AlarmQuery;

import java.text.ParseException;
import java.util.List;

public interface AlarmDao {
    List<Alarm> findAlarm(AlarmQuery alarmQuery) throws ParseException;
}
