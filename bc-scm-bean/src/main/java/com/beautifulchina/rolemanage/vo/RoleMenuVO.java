/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.rolemanage.vo;

import com.beautifulchina.base.BaseBean;

/**
 * 角色菜单
 */

public class RoleMenuVO extends BaseBean{
    /**
     * 角色代码
     */
    private String roleCode;
    /**
     * 角色菜单代码
     */
    private String menuCode;

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}
