/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 2015-10-22
 */
package com.beautifulchina.user.vo;

import com.beautifulchina.base.BaseBean;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 用户VO
 */
public class UserTestVO extends BaseBean {

    private String userId;

    @NotNull(message="{username.not.empty}")
    private String userName;

    private Date userBirthday;

    private Double userSalary;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public Double getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(Double userSalary) {
        this.userSalary = userSalary;
    }
}
