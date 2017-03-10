/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-22
 */

package com.beautifulchina.linetheme.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 线路主题管理
 */
public class LineThemeVO extends PageQuery {
    /**
     * id
     */
    private Integer id;

    /**
     * 主题名称
     */
    private String title;

    /**
     * 主题名称英文
     */
    private String titleEn;

    /**
     * 主题名称法文
     */
    private String titleFr;

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

    private String language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitleFr() {
        return titleFr;
    }

    public void setTitleFr(String titleFr) {
        this.titleFr = titleFr;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
