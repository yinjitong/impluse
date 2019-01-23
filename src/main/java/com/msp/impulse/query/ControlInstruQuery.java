package com.msp.impulse.query;

import com.msp.impulse.base.BaseRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("控制指令查询")
public class ControlInstruQuery extends BaseRequest {
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;
    @ApiModelProperty(name = "executeStatus", value = "开关状态", example = "0-开 1-关", required = true)
    private String  executeStatus;
    @ApiModelProperty(name = "downTimeStart", value = "下发时间开始", example = "", required = true)
    private Date downTimeStart;
    @ApiModelProperty(name = "downTimeEnd", value = "下发时间结束", example = "", required = true)
    private Date  downTimeEnd;
    @ApiModelProperty(name = "dealStatus", value = "处理状态", example = "0-开 1-关", required = true)
    private String  dealStatus;
    @ApiModelProperty(name = "executeTimeStart", value = "执行时间开始", example = "", required = true)
    private  Date  executeTimeStart;
    @ApiModelProperty(name = "executeTimeEnd", value = "执行时间结束", example = "", required = true)
    private  Date  executeTimeEnd;

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getExecuteStatus() {
        return executeStatus;
    }

    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus;
    }

    public Date getDownTimeStart() {
        return downTimeStart;
    }

    public void setDownTimeStart(Date downTimeStart) {
        this.downTimeStart = downTimeStart;
    }

    public Date getDownTimeEnd() {
        return downTimeEnd;
    }

    public void setDownTimeEnd(Date downTimeEnd) {
        this.downTimeEnd = downTimeEnd;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public Date getExecuteTimeStart() {
        return executeTimeStart;
    }

    public void setExecuteTimeStart(Date executeTimeStart) {
        this.executeTimeStart = executeTimeStart;
    }

    public Date getExecuteTimeEnd() {
        return executeTimeEnd;
    }

    public void setExecuteTimeEnd(Date executeTimeEnd) {
        this.executeTimeEnd = executeTimeEnd;
    }
}