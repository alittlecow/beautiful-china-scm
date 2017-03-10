/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-17
 */
package com.beautifulchina.menu.pojo;

import com.beautifulchina.main.bo.ModuleExtjsBO;

/**
 * 模块pojo
 */
public class Module extends ModuleExtjsBO {

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
     * 备注
     */
    private String notes;
    /**
     * 排序字段
     */
    private int sort;

    /**
     * 状态 N:正常 S:停用
     */
    private String status;

    /**
     *  模块代码
     */
    private String plateCode;

    /**
     * 模块名称
     */
    private String moduleName;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
