package com.msp.impulse.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@ApiModel(value = "管理员", description = "管理员")
public class SystemUser implements Serializable {
    @Id
    @ApiModelProperty(name = "Id", value = "用户ID", example = "5bd73ffd72c540e435ecbfbf")
    private String id;
    @ApiModelProperty(name = "account", value = "账号/登录名", example = "admin", required = true)
    private String account;
    @ApiModelProperty(name = "password", value = "密码", example = "admin", required = true)
    private String password;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
}
