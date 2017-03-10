/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-03-14
 */
package com.beautifulchina.tour.vo;

import com.beautifulchina.common.PageQuery;

import java.util.List;

public class TourOptionVO extends PageQuery {
    /**
     * 线路选项id
     */
    private Integer id;
    /**
     * 线路选项id集合
     */
    private List<Integer> idList;
    /**
     * 线路id
     */
    private Integer tourId;
    /**
     * 选项值id
     */
    private Integer valueId;
    /**
     * 选项id
     */
    private Integer optionId;
    /**
     * 差价
     */
    private Double price;
    /**
     * 选项名
     */
    private String optionName;
    /**
     * 选项值名
     */
    private String optionValueName;
    /**
     * 选项值集合
     */
    private List<String> optionValueNameList;
    /**
     * 选项值差价集合
     */
    private List<Double> optionValuePriceList;
    /**
     * 选项值id集合
     */
    private List<Integer> optionValueIdList;

    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 状态
     */
    private String status;
    /**
     * 默认选项
     */
    private List<Integer> defaults;

    /**
     * 游客人数
     */
    private Integer count;

    public List<Integer> getDefaults() {
        return defaults;
    }

    public void setDefaults(List<Integer> defaults) {
        this.defaults = defaults;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Integer> getOptionValueIdList() {
        return optionValueIdList;
    }

    public void setOptionValueIdList(List<Integer> optionValueIdList) {
        this.optionValueIdList = optionValueIdList;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public List<Double> getOptionValuePriceList() {
        return optionValuePriceList;
    }

    public void setOptionValuePriceList(List<Double> optionValuePriceList) {
        this.optionValuePriceList = optionValuePriceList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public String getOptionValueName() {
        return optionValueName;
    }

    public void setOptionValueName(String optionValueName) {
        this.optionValueName = optionValueName;
    }

    public List<String> getOptionValueNameList() {
        return optionValueNameList;
    }

    public void setOptionValueNameList(List<String> optionValueNameList) {
        this.optionValueNameList = optionValueNameList;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
