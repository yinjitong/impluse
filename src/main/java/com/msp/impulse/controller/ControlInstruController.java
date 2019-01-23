package com.msp.impulse.controller;

import com.msp.impulse.base.BaseResponse;
import com.msp.impulse.base.ResponseCode;
import com.msp.impulse.query.ControlInstruQuery;
import com.msp.impulse.service.ControlInstruService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public BaseResponse findControlInstru(@RequestBody ControlInstruQuery controlInstruQuery) {
        BaseResponse response;
        try {
            response = controlInstruService.findControlInstru(controlInstruQuery);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            response = new BaseResponse();
            response.setResponseCode(ResponseCode.SERVER_FAILED.getCode());
            response.setResponseMsg(ResponseCode.SERVER_FAILED.getMessage());
        }
        return response;
    }

    @PostMapping("updateControlInstru")
    @ApiOperation(value = "修改控制指令", notes = "修改控制指令", tags = "控制指令", httpMethod = "POST")
    public BaseResponse updateControlInstru() {
        return null;
    }
}
