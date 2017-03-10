/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-18
 */
package com.beautifulchina.menu.vo;

import com.beautifulchina.common.PageQuery;

import java.util.List;

/**
 * 菜单
 */
public class MenuVO extends PageQuery {

    /**
     * 菜单代码
     */
    private String code;

    /**
     * 模块代码
     */
    private String moduleCode;
    /**
     * 板块代码
     */
    private String plateCode;

    /**
     * 菜单英文名
     */
    private String enName;
    /**
     * 菜单法文名
     */
    private String frName;
    /**
     * 菜单链接
     */
    private String link;

    /**
     * 菜单备注
     */
    private String notes;
    /**
     * 菜单状态
     */
    private String status;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 级别
     */
    private String level;

    /**
     * 级别列表
     */
    private List<Integer> levels;

    /**
     * 语言
     */
    private String language;

    /**
     * 菜单名
     */
    private String menuName;

    public String getMenuName() {
        return menuName;
    }

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

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Integer> getLevels() {
        return levels;
    }

    public void setLevels(List<Integer> levels) {
        this.levels = levels;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

}
