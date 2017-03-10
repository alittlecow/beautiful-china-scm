/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-10
 */
package com.beautifulchina.supplier.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 供应商
 */
public class SupplierVO extends PageQuery {
    /**
     * 部门代码
     */
    private String deptCode;

    /**
     * 供应商名称英文
     */
    private String nameEn;

    /**
     * 供应商名称法文
     */
    private String nameFr;

    /**
     * 状态(N:正常,W:等待确认，S:暂停,R:审批驳回)
     */
    private String status;

    /**
     * 供应商名称
     */
    private String name;


    /**
     * 语言
     */
    private String language;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameFr() {
        return nameFr;
    }

    public void setNameFr(String nameFr) {
        this.nameFr = nameFr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
