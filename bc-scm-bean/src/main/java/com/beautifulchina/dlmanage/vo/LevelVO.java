/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.dlmanage.vo;

import com.beautifulchina.common.PageQuery;

import java.util.Date;

/**
 * 部门等级
 */
public class LevelVO extends PageQuery {

    /**
     * 部门级别代码
     */
    private String code;
    /**
     * 部门级别名称
     */
    private String name;
    /**
     * 上级部门级别代码
     */
    private String supCode;
    /**
     * 部门级别名称英
     */
    private String enName;
    /**
     * 部门级别名称法
     */
    private String fnName;
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 操作人
     */
    private String operating;

    /**
     * 语言
     */
    private String language;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupCode() {
        return supCode;
    }

    public void setSupCode(String supCode) {
        this.supCode = supCode;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getFnName() {
        return fnName;
    }

    public void setFnName(String fnName) {
        this.fnName = fnName;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperating() {
        return operating;
    }

    public void setOperating(String operating) {
        this.operating = operating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
