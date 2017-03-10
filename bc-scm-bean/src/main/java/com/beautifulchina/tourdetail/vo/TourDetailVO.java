/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-25
 */
package com.beautifulchina.tourdetail.vo;

import com.beautifulchina.common.PageQuery;

import java.util.List;

/**
 * 行程数据
 */
public class TourDetailVO extends PageQuery {
    /**
     * 行程详情id
     */
    private Integer id;
    /**
     * 线路id
     */
    private Integer tourId;
    /**
     * 第几天
     */
    private Integer day;
    /**
     * 标题英文
     */
    private String titleEn;
    /**
     * 标题法文
     */
    private String titleFr;
    /**
     * 行程描述英文
     */
    private String contentEn;
    /**
     * 行程描述法文
     */
    private String contentFr;
    /**
     * 封面序号
     */
    private List<Integer> cover;
    /**
     * 图片地址
     */
    private List<String> imageData;

    /**
     * 目的地描述英
     */
    private String destinationEn;
    /**
     * 目的地描述法
     */
    private String destinationFr;
    /**
     * 餐饮安排描述英
     */
    private String mealsEn;
    /**
     * 餐饮安排描述法
     */
    private String mealsFr;
    /**
     * 交通安排描述英
     */
    private String transportEn;
    /**
     * 交通安排描述法
     */
    private String transportFr;
    /**
     * 酒店安排描述英
     */
    private String hotelEn;
    /**
     * 酒店安排描述法
     */
    private String hotelFr;

    public String getDestinationEn() {
        return destinationEn;
    }

    public void setDestinationEn(String destinationEn) {
        this.destinationEn = destinationEn;
    }

    public String getDestinationFr() {
        return destinationFr;
    }

    public void setDestinationFr(String destinationFr) {
        this.destinationFr = destinationFr;
    }

    public String getMealsEn() {
        return mealsEn;
    }

    public void setMealsEn(String mealsEn) {
        this.mealsEn = mealsEn;
    }

    public String getMealsFr() {
        return mealsFr;
    }

    public void setMealsFr(String mealsFr) {
        this.mealsFr = mealsFr;
    }

    public String getTransportEn() {
        return transportEn;
    }

    public void setTransportEn(String transportEn) {
        this.transportEn = transportEn;
    }

    public String getTransportFr() {
        return transportFr;
    }

    public void setTransportFr(String transportFr) {
        this.transportFr = transportFr;
    }

    public String getHotelEn() {
        return hotelEn;
    }

    public void setHotelEn(String hotelEn) {
        this.hotelEn = hotelEn;
    }

    public String getHotelFr() {
        return hotelFr;
    }

    public void setHotelFr(String hotelFr) {
        this.hotelFr = hotelFr;
    }

    public List<Integer> getCover() {
        return cover;
    }

    public void setCover(List<Integer> cover) {
        this.cover = cover;
    }

    public List<String> getImageData() {
        return imageData;
    }

    public void setImageData(List<String> imageData) {
        this.imageData = imageData;
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

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleFr() {
        return titleFr;
    }

    public void setTitleFr(String titleFr) {
        this.titleFr = titleFr;
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
