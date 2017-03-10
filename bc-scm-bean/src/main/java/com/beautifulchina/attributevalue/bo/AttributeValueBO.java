/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-31
 */
package com.beautifulchina.attributevalue.bo;


import com.beautifulchina.base.BaseBean;

/**
 * 属性值
 */
public class AttributeValueBO extends BaseBean{
    /**
     * 属性值id
     */
    private Integer id;
    /**
     *属性id
     */
    private Integer attrId;
    /**
     *属性值英文
     */
    private String value;
    /**
     *属性值英文
     */
    private String valueEn;
    /**
     *属性值法文
     */
    private String valueFr;
    /**
     *排序
     */
    private Integer sort;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public String getValueEn() {
        return valueEn;
    }

    public void setValueEn(String valueEn) {
        this.valueEn = valueEn;
    }

    public String getValueFr() {
        return valueFr;
    }

    public void setValueFr(String valueFr) {
        this.valueFr = valueFr;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
