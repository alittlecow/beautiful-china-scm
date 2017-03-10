/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-10
 */
package com.beautifulchina.attribute.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 分类
 */
public class AttributeVO extends PageQuery {
    /**
     * 属性id
     */
    private Integer attributeId;
    /**
     * 属性名英文
     */
    private String attributeNameEn;
    /**
     * 属性名法文
     */
    private String attributeNameFr;

    /**
     * 分类ID
     */
    private Integer categoryId;
    /**
     * 排序
     */
    private Integer sort;

    /**
     * 属性名英文
     */
    private String attributeName;

    /**
     * 分类名称
     */
    private String  categoryName;
    /**
     * 语言
     */
    private String language;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getAttributeNameEn() {
        return attributeNameEn;
    }

    public void setAttributeNameEn(String attributeNameEn) {
        this.attributeNameEn = attributeNameEn;
    }
    public String getAttributeNameFr() {
        return attributeNameFr;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public void setAttributeNameFr(String attributeNameFr) {
        this.attributeNameFr = attributeNameFr;
    }
}
