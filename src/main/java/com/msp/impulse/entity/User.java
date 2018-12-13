package com.msp.impulse.entity;

import com.bugull.mongo.SimpleEntity;
import com.bugull.mongo.annotations.Embed;
import com.bugull.mongo.annotations.Entity;
import com.bugull.mongo.annotations.Id;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(value = "用户", description = "用户")
public class User extends SimpleEntity {
    @Id
    @ApiModelProperty(name = "Id", value = "用户ID", example = "5bd73ffd72c540e435ecbfbf")
    private String id;
    @ApiModelProperty(name = "name", value = "姓名", example = "殷继彤", required = true)
    private String name;
    @ApiModelProperty(name = "account", value = "账号/登录名", example = "admin", required = true)
    private String account;
    @ApiModelProperty(name = "password", value = "密码", example = "admin", required = true)
    private String password;
    @ApiModelProperty(name = "phoneNo", value = "手机号", example = "13888888888", required = true)
    private  String phoneNo;
    @ApiModelProperty(name = "gender", value = "性别", example = "女", required = true)
    private String gender;
    @ApiModelProperty(name = "email", value = "电子邮箱", example = "aaa@bbb.com", required = true)
    private String email;
    @Embed
    @ApiModelProperty(name = "company", value = "公司信息")
    private Company company;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
