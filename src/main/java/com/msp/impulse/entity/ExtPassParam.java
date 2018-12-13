package com.msp.impulse.entity;

import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.RefList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Entity
@ApiModel(value = "外接通道参数", description = "通道参数")
public class ExtPassParam {
    @ApiModelProperty(name = "passNo", value = "编号", example = "")
    private String passNo;
    @ApiModelProperty(name = "address", value = "地址", example = "北京市海淀区西三旗街道小营东路七号院")
    private String address;
    @RefList
    @ApiModelProperty(name = "passes", value = "通道", example = "[]")
    private List<Pass> passes;

}
