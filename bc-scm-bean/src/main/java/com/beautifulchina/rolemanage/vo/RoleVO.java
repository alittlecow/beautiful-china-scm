/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.rolemanage.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 角色
 */
public class RoleVO extends PageQuery{
    /**
     * 角色代码
     */
    private String roleCode;
    /**
     * 角色英文名
     */
    private String roleEnName;
    /**
     * 角色法文名
     */
    private String roleFrName;

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色等级
     */
    private String roleLevel;
    /**
     * 备注
     */
    private String roleNotes;
    /**
     * 状态
     */
    private String status;

    /**
     * 语言
     */
    private String language;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleEnName() {
        return roleEnName;
    }

    public void setRoleEnName(String roleEnName) {
        this.roleEnName = roleEnName;
    }

    public String getRoleFrName() {
        return roleFrName;
    }

    public void setRoleFrName(String roleFrName) {
        this.roleFrName = roleFrName;
    }

    public String getRoleLevel() {
        return roleLevel;
    }

    public void setRoleLevel(String roleLevel) {
        this.roleLevel = roleLevel;
    }

    public String getRoleNotes() {
        return roleNotes;
    }

    public void setRoleNotes(String roleNotes) {
        this.roleNotes = roleNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
