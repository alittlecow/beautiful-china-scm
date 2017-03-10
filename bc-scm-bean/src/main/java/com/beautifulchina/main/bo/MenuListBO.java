/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-18
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.menu.vo.MenuVO;

/**
 * 菜单列表bean
 */
public class MenuListBO extends MenuVO {
    /**
     * 板块名
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

    public String getPlateName() {
        return plateName;
    }

    public void setPlateName(String plateName) {
        this.plateName = plateName;
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
