package com.msp.impulse.entity;

import io.swagger.annotations.ApiModelProperty;

public class Company {
    @ApiModelProperty(name = "company", value = "公司", example = "殷继彤的海鲜公司", required = true)
    private String company;
    @ApiModelProperty(name = "province", value = "省/市", example = "河北", required = true)
    private String province;
    @ApiModelProperty(name = "city", value = "市/区", example = "唐山", required = true)
    private String city;
    @ApiModelProperty(name = "detailedAdd", value = "详细地址", example = "地震遗址", required = true)
    private String detailedAdd;
    @ApiModelProperty(name = "postalCode", value = "邮政编码", example = "100000", required = true)
    private String postalCode;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
