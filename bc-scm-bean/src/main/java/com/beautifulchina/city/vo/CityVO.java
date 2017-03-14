/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-05
 */
package com.beautifulchina.city.vo;


import com.beautifulchina.annotation.Locale;
import com.beautifulchina.common.PageQuery;

/**
 * 城市
 */
public class CityVO extends PageQuery {

    /**
     *  城市id
     */
    @Locale
    private Integer cityId;

    /**
     * 城市名称
     */
    private String cityName;



    /**
     * 语言
     */
    private String language;



    /**
     * 主题描述法文
     */
    private String desc;
    /**
     * 四张图片
     */

    private String photoOne;
    private String photoTwo;
    private String photoThree;
    private String photoFour;

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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}
