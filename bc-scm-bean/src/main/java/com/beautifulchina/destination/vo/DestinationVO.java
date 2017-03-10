/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-07
 */
package com.beautifulchina.destination.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 目的地
 */
public class DestinationVO extends PageQuery {
    /**
     * 目的地id
     */
    private Integer id;
    /**
     * 目的地城市id
     */
    private Integer cityId;
    /**
     * 标题
     */
    private String title;
    /**
     * 描述
     */
    private String desc;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 状态
     */
    private String status;
    /**
     * 图片1
     */
    private String photoOne;
    /**
     * 图片2
     */
    private String photoTwo;
    /**
     * 图片3
     */
    private String photoThree;
    /**
     * 图片4
     */
    private String photoFour;
    /**
     * 语言
     */
    private String language;

    /**
     * 多语言
     */
    private String multiLanguage;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMultiLanguage() {
        return multiLanguage;
    }

    public void setMultiLanguage(String multiLanguage) {
        this.multiLanguage = multiLanguage;
    }

    public String getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(String photoOne) {
        this.photoOne = photoOne;
    }

    public String getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(String photoTwo) {
        this.photoTwo = photoTwo;
    }

    public String getPhotoThree() {
        return photoThree;
    }

    public void setPhotoThree(String photoThree) {
        this.photoThree = photoThree;
    }

    public String getPhotoFour() {
        return photoFour;
    }

    public void setPhotoFour(String photoFour) {
        this.photoFour = photoFour;
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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
