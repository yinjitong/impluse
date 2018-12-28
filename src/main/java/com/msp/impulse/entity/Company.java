package com.msp.impulse.entity;

import com.bugull.mongo.BuguEntity;
import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "公司", description = "公司")
public class Company  implements BuguEntity {
    @Id
    @ApiModelProperty(name = "id", value = "公司id", example = "1")
    private String id;
    @ApiModelProperty(name = "companyName", value = "公司名称", example = "殷继彤的海鲜公司", required = true)
    private String companyName;
    @ApiModelProperty(name = "province", value = "省/市", example = "河北", required = true)
    private String province;
    @ApiModelProperty(name = "city", value = "市/区", example = "唐山", required = true)
    private String city;
    @ApiModelProperty(name = "detailedAdd", value = "详细地址", example = "", required = true)
    private String detailedAdd;
    @ApiModelProperty(name = "loginName", value = "登录名", example = "殷继彤的海鲜公司", required = true)
    private String loginName;
    @ApiModelProperty(name = "postalCode", value = "邮政编码", example = "100000", required = true)
    private String postalCode;

    @Override
    public String getId() {return id; }

    @Override
    public void setId(String id) { this.id = id;}

    public String getCompanyName() { return companyName; }

    public void setCompanyName(String companyName) { this.companyName = companyName; }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailedAdd() {
        return detailedAdd;
    }

    public void setDetailedAdd(String detailedAdd) {
        this.detailedAdd = detailedAdd;
    }

    public String getLoginName() { return loginName; }

    public void setLoginName(String loginName) { this.loginName = loginName; }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
