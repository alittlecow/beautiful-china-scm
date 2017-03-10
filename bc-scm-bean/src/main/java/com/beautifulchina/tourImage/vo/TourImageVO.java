/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-14
 */
package com.beautifulchina.tourImage.vo;

import com.beautifulchina.base.BaseBean;

/**
 * 旅游线路图片
 */
public class TourImageVO extends BaseBean {
    /**
     * 旅游线路id
     */
    private Integer tourId;
    /**
     * 旅游线路图片保存地址
     */
    private String imageUrl;
    /**
     * 旅游线路图片保存顺序
     */
    private Integer order;
    /**
     * 缩略图
     */
    private Integer thumbnail;

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Integer thumbnail) {
        this.thumbnail = thumbnail;
    }
}
