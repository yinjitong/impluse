package com.msp.impulse.entity;

import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.Ref;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "控制指令", description = "控制指令")
public class ControlInstru {

    @Ref
    @ApiModelProperty(name = "detailedAdd", value = "详细地址", example = "", required = true)
    private Relay relay;
    @ApiModelProperty(name = "dealStatus", value = "处理状态", example = "", required = true)
    private String  dealStatus;
    @ApiModelProperty(name = "returnStatus", value = "返回状态", example = "", required = true)
    private String  returnStatus;
    @ApiModelProperty(name = "downTime", value = "下发时间", example = "", required = true)
    private  Long  downTime;
    @ApiModelProperty(name = "executeTime", value = "执行时间", example = "", required = true)
    private  Long  executeTime;
    @ApiModelProperty(name = "executeTime", value = "附加信息", example = "", required = true)
    private  String   extraMessage;

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

    public Long getDownTime() {
        return downTime;
    }

    public void setDownTime(Long downTime) {
        this.downTime = downTime;
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }

    public String getExtraMessage() {
        return extraMessage;
    }

    public void setExtraMessage(String extraMessage) {
        this.extraMessage = extraMessage;
    }
}
