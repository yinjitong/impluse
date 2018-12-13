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
    @ApiModelProperty(name = "id", value = "网关ID", example = "5be402294932ff3690e3f4ba")
    private String id;
    @ApiModelProperty(name = "equipmentName", value = "设备名称", example = "")
    private String equipmentName;
    @ApiModelProperty(name = "equipmentNo", value = "设备序列号", example = "")
    private int equipmentNo;
    @ApiModelProperty(name = "equipmentType", value = "设备类型", example = "")
    private String equipmentType;
    @ApiModelProperty(name = "equipmentModel", value = "设备型号", example = "")
    private String equipmentModel;
    @ApiModelProperty(name = "totalPass", value = "总通道数", example = "100")
    private Integer totalPass;
    @ApiModelProperty(name = "usablePass", value = "可用通道数", example = "50")
    private Integer usablePass;
    @ApiModelProperty(name = "longitude", value = "经度", example = "116.46176")
    private String longitude;
    @ApiModelProperty(name = "latitude", value = "纬度", example = "39.905859")
    private String latitude;
    @ApiModelProperty(name = "workModel", value = "工作模式", example = "")
    private String workModel;
    @ApiModelProperty(name = "port", value = "端口号", example = "8080")
    private String port;
    @ApiModelProperty(name = "workStatus", value = "工作状态", example = "")
    private String workStatus;
    @ApiModelProperty(name = "relayNumber", value = "继电器数量", example = "")
    private Integer relayNumber;
    @ApiModelProperty(name = "pollPeriod", value = "轮询周期", example = "")
    private String pollPeriod;
    @ApiModelProperty(name = "overtimePeriod", value = "超时周期", example = "")
    private String overtimePeriod;
    @RefList
    @ApiModelProperty(name = "passList", value = "通道参数", example = "[]")
    private List<Pass> passList;
    @RefList
    @ApiModelProperty(name = "extPassParamList", value = "外接通道参数", example = "[]")
    private List<ExtPassParam> extPassParamList;



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

    public int getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(int equipmentNo) {
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

    public Integer getTotalPass() {
        return totalPass;
    }

    public void setTotalPass(Integer totalPass) {
        this.totalPass = totalPass;
    }

    public Integer getUsablePass() {
        return usablePass;
    }

    public void setUsablePass(Integer usablePass) {
        this.usablePass = usablePass;
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

    public Integer getRelayNumber() {
        return relayNumber;
    }

    public void setRelayNumber(Integer relayNumber) {
        this.relayNumber = relayNumber;
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

    public List<Pass> getPassList() {
        return passList;
    }

    public void setPassList(List<Pass> passList) {
        this.passList = passList;
    }

    public List<ExtPassParam> getExtPassParamList() {
        return extPassParamList;
    }

    public void setExtPassParamList(List<ExtPassParam> extPassParamList) {
        this.extPassParamList = extPassParamList;
    }


}
