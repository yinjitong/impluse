package com.msp.impulse.dao;

import com.msp.impulse.entity.DataHistory;
import com.msp.impulse.entity.Pass;
import com.msp.impulse.query.DataHistoryQuery;
import com.msp.impulse.query.PassQuery;
import com.msp.impulse.vo.HomePageDataVo;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


public interface DataManageDao {
    HomePageDataVo findHomeData();

    Map<String, Object> findGatewayMap();

    List<DataHistory> findHistoryData(DataHistoryQuery dataHistoryQuery) throws ParseException;

    List<DataHistory> findRealTimeData(DataHistoryQuery dataHistoryQuery) throws ParseException;
}
