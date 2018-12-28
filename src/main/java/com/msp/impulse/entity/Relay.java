package com.msp.impulse.entity;

import com.bugull.mongo.BuguEntity;
import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.Id;
import com.bugull.mongo.annotations.Ref;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "继电器", description = "继电器")
public class Relay implements BuguEntity {
    @Id
    @ApiModelProperty(name = "id", value = "继电器id", example = "1")
    private String id;
    @Ref
    @ApiModelProperty(name = "gateway", value = "网关", example = "{}")
    private  Gateway gateway;
    @ApiModelProperty(name = "wayNo", value = "路数", example = "{}")
    private  Integer wayNo;
    @ApiModelProperty(name = "status", value = "状态", example = "0-开  1-关")
    private  String status;

    @Override
    public String getId() {return id; }
    @Override
    public void setId(String id) { this.id = id;}

    public Gateway getGateway() { return gateway; }

    public void setGateway(Gateway gateway) { this.gateway = gateway; }

    public Integer getWayNo() { return wayNo; }

    public void setWayNo(Integer wayNo) { this.wayNo = wayNo; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
}
