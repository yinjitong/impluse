package com.msp.impulse.query;

import com.msp.impulse.entity.Company;
import com.msp.impulse.entity.User;
import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel("个人信息")
public class PersonalInfoQuery {

    //公司信息
    private Company company;
    //个人信息
    private User user;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
