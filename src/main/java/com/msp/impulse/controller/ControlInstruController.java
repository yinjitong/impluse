package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.service.ControlInstruService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controlInstru")
@Api(value = "控制指令", tags = "控制指令", description = "控制指令")
public class ControlInstruController {
    private static Logger logger = LoggerFactory.getLogger(ControlInstruController.class);

    @Autowired
    private ControlInstruService controlInstruService;

    @PostMapping("findControlInstru")
    @ApiOperation(value = "查询控制指令", notes = "查询控制指令", tags = "控制指令", httpMethod = "POST")
    public BaseResponse findControlInstru() {
        return null;
    }

    @PostMapping("updateControlInstru")
    @ApiOperation(value = "修改控制指令", notes = "修改控制指令", tags = "控制指令", httpMethod = "POST")
    public BaseResponse updateControlInstru() {
        return null;
    }
}
