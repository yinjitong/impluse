package com.msp.impulse.entity;

import com.bugull.mongo.BuguEntity;
import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "警报", description = "警报")
public class Alarm implements BuguEntity {
    @Id
    @ApiModelProperty(name = "id", value = "警报id", example = "1")
    private String id;
    @ApiModelProperty(name = "pass", value = "通道", example = "1")
    private Pass pass;
    @ApiModelProperty(name="alarmTime",value = "报警时间",example = "")
    private  Long alarmTime;
    @ApiModelProperty(name="closeTime",value = "关闭时间",example = "")
    private  Long closeTime;
    @ApiModelProperty(name="alarmStatus",value = "报警状态",example = "")
    private  String alarmStatus;
    @ApiModelProperty(name="alarmType",value = "报警类型",example = "")
    private  String alarmType;
    @ApiModelProperty(name="testValue",value = "检测值",example = "")
    private  Double testValue;

    @Override
    public String getId() { return id; }

    @Override
    public void setId(String id) { this.id = id; }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }

    public Long getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(Long alarmTime) {
        this.alarmTime = alarmTime;
    }

    public Long getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Long closeTime) {
        this.closeTime = closeTime;
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public Double getTestValue() {
        return testValue;
    }

    public void setTestValue(Double testValue) {
        this.testValue = testValue;
    }
}
