/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2016-02-15
 */
package com.beautifulchina.user.vo;

import com.beautifulchina.base.BaseBean;

/**
 * 用户信息
 */
public class UserVO extends BaseBean{



    /**
     * 登录名
     */
    private String loginName;

    /**
     * 最后登录ip
     */
    private String lastLoginIp;

    /**
     * 最后登录时间
     */
    private String lastLoginTime;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
