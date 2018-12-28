package com.msp.impulse.entity;

import com.bugull.mongo.BuguEntity;
import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.Id;
import com.bugull.mongo.annotations.RefList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Entity
@ApiModel(value = "网关", description = "网关")
public class Gateway implements BuguEntity {
    @Id
    @ApiModelProperty(name = "id", value = "网关ID", example = "1")
    private String id;
    @ApiModelProperty(name = "equipmentName", value = "设备名称", example = "")
    private String equipmentName;
    @ApiModelProperty(name = "equipmentNo", value = "设备序列号", example = "")
    private Integer equipmentNo;
    @ApiModelProperty(name = "equipmentType", value = "设备类型", example = "")
    private String equipmentType;
    @ApiModelProperty(name = "equipmentModel", value = "设备型号", example = "")
    private String equipmentModel;

//    @ApiModelProperty(name = "totalPass", value = "总通道数", example = "100")
//    private Integer totalPass;
//    @ApiModelProperty(name = "usablePass", value = "可用通道数", example = "50")
//    private Integer usablePass;

    @ApiModelProperty(name = "longitude", value = "经度", example = "116.46176")
    private String longitude;
    @ApiModelProperty(name = "latitude", value = "纬度", example = "39.905859")
    private String latitude;
    @ApiModelProperty(name = "workModel", value = "工作模式", example = "")
    private String workModel;
    @ApiModelProperty(name = "port", value = "端口号", example = "8080")
    private String port;

//    @ApiModelProperty(name = "relayNumber", value = "继电器数量", example = "")
//    private Integer relayNumber;

    @ApiModelProperty(name = "pollPeriod", value = "轮询周期", example = "")
    private String pollPeriod;
    @ApiModelProperty(name = "overtimePeriod", value = "超时周期", example = "")
    private String overtimePeriod;
    @RefList
    @ApiModelProperty(name = "pass", value = "通道参数", example = "[]")
    private Pass pass;
    @RefList
    @ApiModelProperty(name = "extPassParamList", value = "外接通道参数", example = "[]")
    private List<ExtPass> extPassParamList;
    @RefList
    @ApiModelProperty(name = "relayList", value = "继电器", example = "[]")
    private  List<Relay> relayList;
    @ApiModelProperty(name = "workStatus", value = "工作状态", example = "0-开 1-关")
    private String workStatus;
    @ApiModelProperty(name="deleteFlag",value = "删除标志",example = "0-使用1-删除")
    private  String  deleteFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public Integer getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(Integer equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(String equipmentType) {
        this.equipmentType = equipmentType;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getWorkModel() {
        return workModel;
    }

    public void setWorkModel(String workModel) {
        this.workModel = workModel;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }

    public String getPollPeriod() {
        return pollPeriod;
    }

    public void setPollPeriod(String pollPeriod) {
        this.pollPeriod = pollPeriod;
    }

    public String getOvertimePeriod() {
        return overtimePeriod;
    }

    public void setOvertimePeriod(String overtimePeriod) {
        this.overtimePeriod = overtimePeriod;
    }

    public Pass getPass() { return pass; }

    public void setPass(Pass pass) { this.pass = pass; }

    public List<ExtPass> getExtPassParamList() {
        return extPassParamList;
    }

    public void setExtPassParamList(List<ExtPass> extPassParamList) {
        this.extPassParamList = extPassParamList;
    }

    public List<Relay> getRelayList() { return relayList; }

    public void setRelayList(List<Relay> relayList) { this.relayList = relayList; }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
