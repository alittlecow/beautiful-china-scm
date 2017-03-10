/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2016-01-18
 */
package com.beautifulchina.rolemanage.vo;

import com.beautifulchina.base.Base;

import java.util.List;

/**
 * 保存角色菜单入参
 */
public class SaveRoleMenuVO extends Base {
    /** 菜单代码 */
    private List<String> menuCodes;
    /** 角色代码 */
    private String roleCode;

    public List<String> getMenuCodes() {
        return menuCodes;
    }

    public void setMenuCodes(List<String> menuCodes) {
        this.menuCodes = menuCodes;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
