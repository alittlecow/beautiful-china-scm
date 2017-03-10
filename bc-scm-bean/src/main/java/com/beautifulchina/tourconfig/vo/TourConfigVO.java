/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-14
 */
package com.beautifulchina.tourconfig.vo;

import com.beautifulchina.base.BaseBean;

/**
 * 旅游线路配置
 */
public class TourConfigVO extends BaseBean {
    /**
     * 配置id
     */
    private Integer id;
    /**
     * 旅游线路id
     */
    private Integer tourId;
    /**
     * 配置类型
     */
    private String type;
    /**
     * 配置内容英
     */
    private String contentEn;
    /**
     * 配置内容法
     */
    private String contentFr;
    /**
     * 配置名称
     */
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContentEn() {
        return contentEn;
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public String getContentFr() {
        return contentFr;
    }

    public void setContentFr(String contentFr) {
        this.contentFr = contentFr;
    }
}
