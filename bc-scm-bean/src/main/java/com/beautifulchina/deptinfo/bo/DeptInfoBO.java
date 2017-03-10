/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2016-02-03
 */
package com.beautifulchina.deptinfo.bo;

import com.beautifulchina.base.BaseBean;

/**
 * 部门信息
 */
public class DeptInfoBO extends BaseBean {
    /**
     * 部门id
     */
    private Integer id;
    /**
     * 部门代码
     */
    private String deptCode;
    /**
     * 部门等级代码
     */
    private String levelCode;

    /**
     * 上级部门
     */
    private String supDept;
    /**
     * 状态
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
     * 级别名称
     */
    private String levelNameEn;

    /**
     * 级别名称法文
     */
    private String levelNameFr;

    /**
     * 上级级别
     */
    private String levelParent;

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

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
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

    public String getLevelNameEn() {
        return levelNameEn;
    }

    public void setLevelNameEn(String levelNameEn) {
        this.levelNameEn = levelNameEn;
    }

    public String getLevelNameFr() {
        return levelNameFr;
    }

    public void setLevelNameFr(String levelNameFr) {
        this.levelNameFr = levelNameFr;
    }
}
