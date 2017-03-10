package com.beautifulchina.order.pojo;

/**
 * Created by ZHF on 2016/3/11.
 */
public class OrderDetail {
    /**
     * id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 选项名
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 值id
     */
    private Integer valueId;

    /**
     * 是否升级服务
     */
    private String upGrade;

    /**
     * 差价
     */
    private Double price;

    /**
     * 总价
     */
    private Double totalPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public String getUpGrade() {
        return upGrade;
    }

    public void setUpGrade(String upGrade) {
        this.upGrade = upGrade;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
