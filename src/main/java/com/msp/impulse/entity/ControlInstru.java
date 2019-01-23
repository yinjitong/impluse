package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "控制指令", description = "控制指令")
public class ControlInstru implements Serializable {

    @DBRef
    @ApiModelProperty(name = "relay", value = "继电器", example = "", required = true)
    private Relay relay;
    @ApiModelProperty(name = "nowStatus", value = "当前状态", example = "0-开 1-关", required = true)
    private String  nowStatus;
    @ApiModelProperty(name = "dealStatus", value = "处理状态", example = "0-开 1-关", required = true)
    private String  dealStatus;
    @ApiModelProperty(name = "returnStatus", value = "返回状态", example = "0-失败 1-成功", required = true)
    private String  returnStatus;
    @ApiModelProperty(name = "downTime", value = "下发时间", example = "", required = true)
    private  Date  downTime;
    @ApiModelProperty(name = "executeTime", value = "执行时间", example = "", required = true)
    private  Date  executeTime;
    @ApiModelProperty(name = "executeTime", value = "附加信息", example = "", required = true)
    private  String   extraMessage;
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "", required = true)
    private  String   gatewayName;
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "", required = true)
    private  String   sensorName;
    @ApiModelProperty(name = "updateTime", value = "更新时间", example = "2019-01-01 00:00:00", required = true)
    private Date updateTime;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;

    public Relay getRelay() {
        return relay;
    }

    public void setRelay(Relay relay) {
        this.relay = relay;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Date getDownTime() {
        return downTime;
    }

    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    public Date getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public void setExtraMessage(String extraMessage) {
        this.extraMessage = extraMessage;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
