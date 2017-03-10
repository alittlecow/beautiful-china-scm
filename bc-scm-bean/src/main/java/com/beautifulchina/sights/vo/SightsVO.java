/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-05
 */
package com.beautifulchina.sights.vo;

import com.beautifulchina.common.PageQuery;

public class SightsVO extends PageQuery {
    /**
     * 传入的语言
     */
    private String language;
    /**
     * 景点id
     */
    private Integer id;
    /**
     * 所属城市id
     */
    private Integer cityId;
    /**
     * 景点英文名
     */
    private String nameEn;
    /**
     * 景点法文名
     */
    private String NameFr;
    /**
     * 景点描述英文
     */
    private String descEn;
    /**
     * 景点描述法文
     */
    private String descFr;
    /**
     * 景点描述
     */
    private String desc;
    /**
     * 推荐等级
     */
    private String level;
    /**
     * 景点价格
     */
    private Double price;
    /**
     * 所属城市英文名
     */
    private String cityNameEn;

    /**
     * 所属城市法文名
     */
    private String cityNameFr;
    /**
     * 景点名称
     */
    private String name;
    /**
     * 所属城市名称
     */
    private String cityName;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCityNameFr() {
        return cityNameFr;
    }

    public void setCityNameFr(String cityNameFr) {
        this.cityNameFr = cityNameFr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameFr() {
        return NameFr;
    }

    public void setNameFr(String nameFr) {
        NameFr = nameFr;
    }

    public String getDescEn() {
        return descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn;
    }

    public String getDescFr() {
        return descFr;
    }

    public void setDescFr(String descFr) {
        this.descFr = descFr;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
