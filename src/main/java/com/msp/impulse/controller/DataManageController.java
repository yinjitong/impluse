package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.query.GatewayQuery;
import com.msp.impulse.service.DataManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dataManage")
@Api(value = "数据管理", tags = "数据管理", description = "数据管理")
public class DataManageController {
    private static Logger logger = LoggerFactory.getLogger(DataManageController.class);
    @Autowired
    private DataManageService dataManageService;

    @PostMapping("findSenorByCondition")
    @ApiOperation(value = "首页总览", notes = "首页总览", tags = "数据管理", httpMethod = "POST")
    public BaseResponse findSenorByCondition(@RequestBody GatewayQuery gatewayQuery) {
        return null;
    }

    @PostMapping("findRealTimeData")
    @ApiOperation(value = "查询实时数据", notes = "查询实时数据", tags = "数据管理", httpMethod = "POST")
    public BaseResponse findRealTimeData() {
        return null;
    }

    @PostMapping("findHistoryData")
    @ApiOperation(value = "查询历史数据", notes = "查询历史数据", tags = "数据管理", httpMethod = "POST")
    public BaseResponse findHistoryData() {
        return null;
    }

    @PostMapping("findMapData")
    @ApiOperation(value = "查询地图数据", notes = "查询地图数据", tags = "数据管理", httpMethod = "POST")
    public BaseResponse findMapData() {
        return null;
    }
}
