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
 * 平台用户（用于查询的VO）
 */
public class PlatformQuryVO extends PageQuery {
    /**
     * 用户名
     */
    private String name;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 部门名代码
     */
    private String deptCode;
    /**
     * 角色代码
     */
    private String roleCode;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 管理级别
     */
    private String levelCode;

    /**
     * 语言
     */
    private String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
