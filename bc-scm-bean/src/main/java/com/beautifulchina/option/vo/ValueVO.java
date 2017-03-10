/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-22
 */
package com.beautifulchina.option.vo;

import com.beautifulchina.common.PageQuery;

import java.math.BigDecimal;

/**
 * 选项值
 */
public class ValueVO extends PageQuery{
    /**
     * 选项值id
     */
    private Integer valueId;

    /**
     * 选项id
     */
    private  Integer optionId;

    /**
     * 选项值英文
     */
    private String optionEnValue;

    /**
     * 选项值法文
     */
    private String optionFrValue;

    /**
     * 选项值
     */
    private String optionValue;

    /**
     * 备注英文
     */
    private String optionEnNotes;

    /**
     * 备注法文
     */
    private String optionFrNotes;


    /**
     * 备注
     */
    private String optionNotes;

    /**
     * 语言
     */
    private String language;

    /**
     * 选项差价
     * @return
     */
    private BigDecimal optionPrice;

    public String getOptionNotes() {
        return optionNotes;
    }

    public void setOptionNotes(String optionNotes) {
        this.optionNotes = optionNotes;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public BigDecimal getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(BigDecimal optionPrice) {
        this.optionPrice = optionPrice;
    }

    public String getOptionEnValue() {
        return optionEnValue;
    }

    public void setOptionEnValue(String optionEnValue) {
        this.optionEnValue = optionEnValue;
    }

    public String getOptionFrValue() {
        return optionFrValue;
    }

    public void setOptionFrValue(String optionFrValue) {
        this.optionFrValue = optionFrValue;
    }

    public String getOptionEnNotes() {
        return optionEnNotes;
    }

    public void setOptionEnNotes(String optionEnNotes) {
        this.optionEnNotes = optionEnNotes;
    }

    public String getOptionFrNotes() {
        return optionFrNotes;
    }

    public void setOptionFrNotes(String optionFrNotes) {
        this.optionFrNotes = optionFrNotes;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
