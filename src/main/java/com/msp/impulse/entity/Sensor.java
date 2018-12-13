package com.msp.impulse.entity;

import com.bugull.mongo.annotations.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Entity
@ApiModel(value = "传感器", description = "传感器")
public class Sensor {
    @Id
    @ApiModelProperty(name = "id", value = "传感器ID", example = "5be402294932ff3690e3f4ba")
    private  String id;
    @ApiModelProperty(name = "sensorNo", value = "传感器序列号", example = "",required = true)
    private  String sensorNo;
    @ApiModelProperty(name = "name", value = "名称", example = "温度传感器", required = true)
    private String name;
    @Ref
    @ApiModelProperty(name = "gateway", value = "网关", example = "", required = true)
    private Gateway gateway;
    @ApiModelProperty(name = "longitude", value = "经度", example = "116.46176")
    private  String  longitude;
    @ApiModelProperty(name = "latitude", value = "纬度", example = "39.905859")
    private String latitude;
    @ApiModelProperty(name = "pass", value = "通道参数", example = "[]")
    private Pass pass;

}
