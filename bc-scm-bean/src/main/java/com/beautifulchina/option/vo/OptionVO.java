/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-22
 */
package com.beautifulchina.option.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 选项
 */
public class OptionVO extends PageQuery{
    /**
     * 选项id
     */
    private  Integer optionId;

    /**
     * 选项英文名
     */
    private String optionEnName;

    /**
     * 选项法文名
     */
    private String optionFrName;

    /**
     * 选项名
     */
    private String optionName;

    /**
     * 语言
     */
    private String language;

    /**
     * 供应商代码
     */
    private String deptCode;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionEnName() {
        return optionEnName;
    }

    public void setOptionEnName(String optionEnName) {
        this.optionEnName = optionEnName;
    }

    public String getOptionFrName() {
        return optionFrName;
    }

    public void setOptionFrName(String optionFrName) {
        this.optionFrName = optionFrName;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
}
