/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-17
 */
package com.beautifulchina.menu.pojo;

import com.beautifulchina.menu.bo.MenuBO;

/**
 * 菜单pojo
 */
public class Menu extends MenuBO {
    /**
     * 板块名称
     */
    private String plateName;

    /**
     * 板块英文名
     */
    private String plateEnName;
    /**
     * 板块法文名
     */
    private String plateFrName;
    /**
     * 模块英文名
     */
    private String moduleEnName;
    /**
     * 模块法文名
     */
    private String moduleFrName;

    /**
     * 角色代码
     */
    private String roleCode;

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getPlateEnName() {
        return plateEnName;
    }

    public void setPlateEnName(String plateEnName) {
        this.plateEnName = plateEnName;
    }

    public String getPlateFrName() {
        return plateFrName;
    }

    public void setPlateFrName(String plateFrName) {
        this.plateFrName = plateFrName;
    }

    public String getModuleEnName() {
        return moduleEnName;
    }

    public void setModuleEnName(String moduleEnName) {
        this.moduleEnName = moduleEnName;
    }

    public String getModuleFrName() {
        return moduleFrName;
    }

    public void setModuleFrName(String moduleFrName) {
        this.moduleFrName = moduleFrName;
    }
}
