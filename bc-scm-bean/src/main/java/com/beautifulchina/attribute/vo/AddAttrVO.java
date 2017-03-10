/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-10
 */
package com.beautifulchina.attribute.vo;


/**
 * 用于新增属性的属性VO对象
 */
public class AddAttrVO {
    /**
     * 属性id
     */
    private Integer id;
    /**
     * 属性名英文
     */
    private String attributeNameEn;
    /**
     * 属性名法文
     */
    private String attributeNameFr;

    /**
     *排序
     */
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setAttributeNameFr(String attributeNameFr) {
        this.attributeNameFr = attributeNameFr;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
