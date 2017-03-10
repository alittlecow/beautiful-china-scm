/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-18
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.menu.vo.ModuleVO;

/**
 * 模块
 */
public class ModuleBO extends ModuleVO {
    /**
     * 编号
     */
    private String code;
    /**
     * 英文名
     */
    private String enName;
    /**
     * 法文名
     */
    private String frName;

    /**
     * 模块名
     */
    private String moduleName;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getFrName() {
        return frName;
    }

    public void setFrName(String frName) {
        this.frName = frName;
    }
}
