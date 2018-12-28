package com.msp.impulse.entity;

import com.bugull.mongo.BuguEntity;
import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.Id;
import com.bugull.mongo.annotations.RefList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@Entity
@ApiModel(value = "外接通道参数", description = "通道参数")
public class ExtPass implements BuguEntity {
    @Id
    @ApiModelProperty(name = "id", value = "外接通道ID", example = "1")
    private String id;
    @ApiModelProperty(name = "passNo", value = "编号", example = "1")
    private String passNo;
    @ApiModelProperty(name = "address", value = "地址", example = "北京市海淀区西三旗街道小营东路七号院")
    private String address;
    @RefList
    @ApiModelProperty(name = "passes", value = "通道", example = "[]")
    private List<Pass> passes;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Pass> getPasses() {
        return passes;
    }

    public void setPasses(List<Pass> passes) {
        this.passes = passes;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
