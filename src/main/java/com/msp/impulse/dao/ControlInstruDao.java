package com.msp.impulse.dao;

import com.msp.impulse.entity.Alarm;
import com.msp.impulse.entity.ControlInstru;
import com.msp.impulse.query.ControlInstruQuery;

import java.util.List;

public interface ControlInstruDao {
    void  save(ControlInstru controlInstru);

    List<ControlInstru> findControlInstru(ControlInstruQuery controlInstruQuery);

    List<ControlInstru> getControlInstruList();
}
