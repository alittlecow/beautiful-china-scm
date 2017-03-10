/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.deptinfo.vo;

import com.beautifulchina.base.BaseBean;

/**
 * 部门信息
 */
public class DeptVO extends BaseBean{
    /**
     * 部门id
     */
    private Integer id;
    /**
     * 部门代码
     */
    private String deptCode;
    /**
     *部门等级代码
     */
    private String levelCode;
    /**
     *部门名称
     */
    private String deptName;
    /**
     *上级部门
     */
    private String supDept;
    /**
     *状态
     */
    private String status;

    /**
     * 部门名称英文
     */
    private String deptNameEn;

    /**
     * 部门名称法文
     */
    private String deptNameFr;

    /**
     * 语言
     */
    private String language;

    /**
     * 角色级别
     */
    private String roleLevel;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDeptNameEn() {
        return deptNameEn;
    }

    public void setDeptNameEn(String deptNameEn) {
        this.deptNameEn = deptNameEn;
    }

    public String getDeptNameFr() {
        return deptNameFr;
    }

    public void setDeptNameFr(String deptNameFr) {
        this.deptNameFr = deptNameFr;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSupDept() {
        return supDept;
    }

    public void setSupDept(String supDept) {
        this.supDept = supDept;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }
}
