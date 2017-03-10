/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-10
 */
package com.beautifulchina.platform.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 平台用户
 */
public class PlatformVO extends PageQuery {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 随机码
     */
    private String authcode;
    /**
     * 操作时间
     */
    private String operatetime;
    /**
     * 盐值
     */
    private String psw;
    /**
     * 登录名
     */
    private String loginName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAuthcode() {
        return authcode;
    }

    public void setAuthcode(String authcode) {
        this.authcode = authcode;
    }

    public String getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(String operatetime) {
        this.operatetime = operatetime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
