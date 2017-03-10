/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-10
 */
package com.beautifulchina.attribute.bo;


import com.beautifulchina.attribute.vo.AttributeVO;


/**
 * 属性
 */
public class AttributeBO extends AttributeVO {



    /**
     * 属性值id
     */
    private Integer attributeValueId;

    /**
     * 分类名称英文
     */
    private String  categoryNameEn;


    /**
     * 属性值英文
     */
    private String attributeValueEn;
    /**
     * 属性值法文
     */
    private String attributeValueFr;
    /**
     *属性值
     */
    private String attributeValue;

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public String getCategoryNameEn() {
        return categoryNameEn;
    }

    public void setCategoryNameEn(String categoryNameEn) {
        this.categoryNameEn = categoryNameEn;
    }

    public String getAttributeValueEn() {
        return attributeValueEn;
    }

    public void setAttributeValueEn(String attributeValueEn) {
        this.attributeValueEn = attributeValueEn;
    }

    public String getAttributeValueFr() {
        return attributeValueFr;
    }

    public void setAttributeValueFr(String attributeValueFr) {
        this.attributeValueFr = attributeValueFr;
    }





    public Integer getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(Integer attributeValueId) {
        this.attributeValueId = attributeValueId;
    }
}
