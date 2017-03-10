/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-23
 */
package com.beautifulchina.tourdate.vo;

import com.beautifulchina.common.PageQuery;

import java.util.Date;
import java.util.List;

/**
 * 线路出发数据
 */
public class TourDateVO  extends PageQuery{
    private String language;
    /**
     * id
     */
    private Integer id;
    /**
     * 线路代码
     */
    private String code;
    /**
     * 出发时间
     */
    private Date time;
    /**
     * 当日价格
     */
    private Double price;
    /**
     * 库存总数
     */
    private Integer inventory;
    /**
     * 已售数量
     */
    private Integer sales;
    /**
     * 已提交数量
     */
    private Integer pending;
    /**
     * 剩余库存
     */
    private Integer remain;
    /**
     * 预警值库存
     */
    private Integer warn;
    /**
     * 是否预警
     */
    private String warning;
    /**
     * 库存取值范围上限
     */
    private Integer inventoryFrom;
    /**
     * 库存取值范围下限
     */
    private Integer inventoryTo;
    /**
     * 已售库存取值范围上限
     */
    private Integer salesFrom;
    /**
     * 已售库存取值范围下限
     */
    private Integer salesTo;
    /**
     * 剩余库存取值范围上限
     */
    private Integer remainFrom;
    /**
     * 剩余库存取值范围下限
     */
    private Integer remainTo;

    /**
     * 存储类型
     */
    private String type;
    /**
     * 开始日期
     */
    private Date startTime;
    /**
     * 结束日期
     */
    private Date endTime;
    /**
     * 日期号
     */
    private  List<Integer> dateIndex;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<Integer> getDateIndex() {
        return dateIndex;
    }

    public void setDateIndex(List<Integer> dateIndex) {
        this.dateIndex = dateIndex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getInventoryFrom() {
        return inventoryFrom;
    }

    public void setInventoryFrom(Integer inventoryFrom) {
        this.inventoryFrom = inventoryFrom;
    }

    public Integer getInventoryTo() {
        return inventoryTo;
    }

    public void setInventoryTo(Integer inventoryTo) {
        this.inventoryTo = inventoryTo;
    }

    public Integer getSalesFrom() {
        return salesFrom;
    }

    public void setSalesFrom(Integer salesFrom) {
        this.salesFrom = salesFrom;
    }

    public Integer getSalesTo() {
        return salesTo;
    }

    public void setSalesTo(Integer salesTo) {
        this.salesTo = salesTo;
    }

    public Integer getRemainFrom() {
        return remainFrom;
    }

    public void setRemainFrom(Integer remainFrom) {
        this.remainFrom = remainFrom;
    }

    public Integer getRemainTo() {
        return remainTo;
    }

    public void setRemainTo(Integer remainTo) {
        this.remainTo = remainTo;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getPending() {
        return pending;
    }

    public void setPending(Integer pending) {
        this.pending = pending;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public Integer getWarn() {
        return warn;
    }

    public void setWarn(Integer warn) {
        this.warn = warn;
    }
}
