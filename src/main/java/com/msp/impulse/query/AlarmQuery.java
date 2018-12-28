package com.msp.impulse.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

@ApiModel("报警查询")
public class AlarmQuery{
    @ApiModelProperty(name = "gatewayName", value = "网关名称", example = "")
    private String gatewayName;
    @ApiModelProperty(name = "sensorName", value = "传感器名称", example = "")
    private String sensorName;
    @ApiModelProperty(name = "alarmType", value = "报警类型", example = "")
    private String alarmType;
    @ApiModelProperty(name = "alarmStatus", value = "报警状态", example = "")
    private String alarmStatus;
    @ApiModelProperty(name="alarmDateFrom",value = "报警时间from" , example="")
    private  Long  alarmDateFrom;
    @ApiModelProperty(name="alarmDateTo",value="报警时间to",example="")
    private  Long  alarmDateTo;
    @ApiModelProperty(name="closeDateFrom",value="关闭时间from",example="")
    private Long closeDateFrom;
    @ApiModelProperty(name="closeDateTo",value="关闭时间to",example="")
    private  Long  closeDateTo;

    public String getGatewayName() {
        return gatewayName;
    }

    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(String alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(String alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public Long getAlarmDateFrom() {
        return alarmDateFrom;
    }

    public void setAlarmDateFrom(Long alarmDateFrom) {
        this.alarmDateFrom = alarmDateFrom;
    }

    public Long getAlarmDateTo() {
        return alarmDateTo;
    }

    public void setAlarmDateTo(Long alarmDateTo) {
        this.alarmDateTo = alarmDateTo;
    }

    public Long getCloseDateFrom() {
        return closeDateFrom;
    }

    public void setCloseDateFrom(Long closeDateFrom) {
        this.closeDateFrom = closeDateFrom;
    }

    public Long getCloseDateTo() {
        return closeDateTo;
    }

    public void setCloseDateTo(Long closeDateTo) {
        this.closeDateTo = closeDateTo;
    }
}
