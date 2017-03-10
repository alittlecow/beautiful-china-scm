/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-10
 */
package com.beautifulchina.platform.bo;

import com.beautifulchina.platform.vo.PlatformVO;

import java.util.Date;

/**
 * 平台用户
 */
public class PlatformBO extends PlatformVO {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 部门代码
     */
    private String deptCode;
    /**
     * 角色代码
     */
    private String roleCode;
    /**
     * 登录时间
     */
    private Date loginTime;
    /**
     * 登录IP
     */
    private String loginIp;
    /**
     * 状态 N:正常 S:停用
     */
    private String status;
    /**
     * 联系电话
     */
    private String tel;
    /**
     * 联系电话2
     */
    private String tel2;

    /**
     * 角色英文名
     */
    private String roleNameEn;
    /**
     * 角色法文名
     */
    private String roleNameFr;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 部门法文名
     */
    private String deptNameEn;

    /**
     * 部门英文名
     */
    private String deptNameFr;

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

    public String getRoleNameEn() {
        return roleNameEn;
    }

    public void setRoleNameEn(String roleNameEn) {
        this.roleNameEn = roleNameEn;
    }

    public String getRoleNameFr() {
        return roleNameFr;
    }

    public void setRoleNameFr(String roleNameFr) {
        this.roleNameFr = roleNameFr;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

}
