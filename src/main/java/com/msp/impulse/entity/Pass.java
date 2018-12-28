package com.msp.impulse.entity;

import com.bugull.mongo.BuguEntity;
import com.bugull.mongo.SimpleEntity;
import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.Id;
import com.bugull.mongo.annotations.Ref;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "通道", description = "通道")
public class Pass implements BuguEntity {

    @Id
    @ApiModelProperty(name = "id", value = "通道id", example = "5be402294932ff3690e3f4ba")
    private  String id;
    @ApiModelProperty(name = "passNo", value = "通道号", example = "")
    private  String passNo;
    @Ref
    @ApiModelProperty(name = "gateway", value = "网关", example = "{}")
    private  Gateway gateway;
    @Ref
    @ApiModelProperty(name = "sensor", value = "传感器", example = "{}")
    private  Sensor sensor;
    @ApiModelProperty(name = "alarmCeil", value = "报警上限", example = "")
    private  String alarmCeil;
    @ApiModelProperty(name = "alarmFloor", value = "报警下限", example = "")
    private  String alarmFloor;
    @ApiModelProperty(name = "ceilStatus", value = "上限状态", example = "")
    private  String ceilStatus;
    @ApiModelProperty(name = "floorStatus", value = "下限状态", example = "")
    private  String floorStatus;
    @ApiModelProperty(name = "sensorType", value = "模拟信号量程-零度", example = "")
    private  String analogZero;
    @ApiModelProperty(name = "sensorType", value = "模拟信号量程-满点", example = "")
    private  String analogFull;
    @ApiModelProperty(name = "sensorType", value = "传感器量程-零度", example = "")
    private  String sensorZero;
    @ApiModelProperty(name = "sensorType", value = "传感器量程-满点", example = "")
    private  String sensorFull;
    @ApiModelProperty(name = "decimalPlaces", value = "小数点位数", example = "3")
    private  String decimalPlaces;
    @ApiModelProperty(name="deleteFlag",value = "删除标志",example = "0-使用1-删除")
    private  String  deleteFlag;

    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }
    public String getPassNo() {
        return passNo;
    }

    public void setPassNo(String passNo) {
        this.passNo = passNo;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getAlarmCeil() {
        return alarmCeil;
    }

    public void setAlarmCeil(String alarmCeil) {
        this.alarmCeil = alarmCeil;
    }

    public String getAlarmFloor() {
        return alarmFloor;
    }

    public void setAlarmFloor(String alarmFloor) {
        this.alarmFloor = alarmFloor;
    }

    public String getCeilStatus() {
        return ceilStatus;
    }

    public void setCeilStatus(String ceilStatus) {
        this.ceilStatus = ceilStatus;
    }

    public String getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(String floorStatus) {
        this.floorStatus = floorStatus;
    }

    public String getAnalogZero() {
        return analogZero;
    }

    public void setAnalogZero(String analogZero) {
        this.analogZero = analogZero;
    }

    public String getAnalogFull() {
        return analogFull;
    }

    public void setAnalogFull(String analogFull) {
        this.analogFull = analogFull;
    }

    public String getSensorZero() {
        return sensorZero;
    }

    public void setSensorZero(String sensorZero) {
        this.sensorZero = sensorZero;
    }

    public String getSensorFull() {
        return sensorFull;
    }

    public void setSensorFull(String sensorFull) {
        this.sensorFull = sensorFull;
    }

    public String getDecimalPlaces() { return decimalPlaces; }

    public void setDecimalPlaces(String decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public String getDeleteFlag() { return deleteFlag; }

    public void setDeleteFlag(String deleteFlag) { this.deleteFlag = deleteFlag; }
}
