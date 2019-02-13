package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "继电器", description = "继电器")
public class Relay implements Serializable {
    @Id
    @ApiModelProperty(name = "id", value = "继电器id", example = "1")
    private String id;
    @ApiModelProperty(name = "wayNo", value = "路数", example = "{}")
    private  Integer wayNo;
    @ApiModelProperty(name = "status", value = "处理状态", example = "0-开  1-关")
    private  String status;
    @ApiModelProperty(name = "returnStatus", value = "返回状态", example = "0-成功  1-失败")
    private  String returnStatus;
    @ApiModelProperty(name = "createTime", value = "创建时间", example = "2019-01-01 00:00:00", required = true)
    private Date createTime;

    public String getId() {return id; }
    public void setId(String id) { this.id = id;}

    public Integer getWayNo() { return wayNo; }

    public void setWayNo(Integer wayNo) { this.wayNo = wayNo; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public String getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(String returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
