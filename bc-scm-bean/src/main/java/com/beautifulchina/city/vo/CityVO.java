/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-05
 */
package com.beautifulchina.city.vo;


import com.beautifulchina.common.PageQuery;

/**
 * 城市
 */
public class CityVO extends PageQuery {

    /**
     *  城市id
     */
    private Integer cityId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     *  城市名称英文
     */
    private String cityNameEn;

    /**
     *  城市名称法语
     */
    private String cityNameFr;

    /**
     * 语言
     */
    private String language;

    /**
     * 主题描述英文
     */
    private String descEn;

    /**
     * 主题描述法文
     */
    private String descFr;
    /**
     * 四张图片
     */

    private String photoOne;
    private String photoTwo;
    private String photoThree;
    private String photoFour;

    public String getDescEn() {
        return descEn;
    }

    public void setDescEn(String descEn) {
        this.descEn = descEn;
    }

    public String getPhotoFour() {
        return photoFour;
    }

    public void setPhotoFour(String photoFour) {
        this.photoFour = photoFour;
    }

    public String getPhotoThree() {
        return photoThree;
    }

    public void setPhotoThree(String photoThree) {
        this.photoThree = photoThree;
    }

    public String getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(String photoTwo) {
        this.photoTwo = photoTwo;
    }

    public String getDescFr() {
        return descFr;
    }

    public void setDescFr(String descFr) {
        this.descFr = descFr;
    }

    public String getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(String photoOne) {
        this.photoOne = photoOne;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }

    public String getCityNameFr() {
        return cityNameFr;
    }

    public void setCityNameFr(String cityNameFr) {
        this.cityNameFr = cityNameFr;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
