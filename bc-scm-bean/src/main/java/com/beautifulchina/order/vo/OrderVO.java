/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-20
 */
package com.beautifulchina.order.vo;


import com.beautifulchina.common.PageQuery;

import java.util.Date;

/**
 * 订单
 */
public class OrderVO extends PageQuery {

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 购买者id
     */
    private Integer userId;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系人邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 供应商代码
     */
    private String deptCode;

    /**
     * 线路id
     */
    private Integer tourId;

    /**
     * 成人数
     */
    private Integer adults;

    /**
     * 儿童数
     */
    private Integer children;

    /**
     * 房间数
     */
    private Integer room;

    /**
     * 出团时间
     */
    private Date departure;

    /**
     * 订单总额
     */
    private Double total;

    /**
     * 订单状态
     */
    private String stete;

    /**
     * 下单时间
     */
    private Date placedTime;

    /**
     * 积分
     */
    private int point;

    /**
     *总差价
     */
    private double gross;

    /**
     * 净额
     */
    private double net;

    /**
     * 税额
     */
    private double tax;

    /**
     * 下单时间(从)
     */
    private Date placedFrom;

    /**
     * 下单时间(到)
     */
    private Date placedTo;

    /**
     * 订单状态
     */
    private String state;

    /**
     * 购买者姓名
     */
    private String userName;

    /**
     * 线路名称
     */
    private String tourName;

    /**
     * 部门级别代码
     */
    private String levelCode;

    /**
     * 供应商id
     */
    private Integer deptId;

    /**
     * 语言
     */
    private String language;

    /**
     * 客户姓名
     */
    private String fullname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 护照号
     */
    private String passport;

    /**
     *  联系电话
     */
    private String phone;

    /**
     * 类型
     */
    private String type;

    /**
     * 选项名称
     */
    private String optionName;

    /**
     * 选项价格
     */
    private double optionPrice;

    /**
     * 选项值id
     */
    private Integer valueId;

    /**
     * 是否选中
     */
    private boolean check;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getPlacedFrom() {
        return placedFrom;
    }

    public void setPlacedFrom(Date placedFrom) {
        this.placedFrom = placedFrom;
    }

    public Date getPlacedTo() {
        return placedTo;
    }

    public void setPlacedTo(Date placedTo) {
        this.placedTo = placedTo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStete() {
        return stete;
    }

    public void setStete(String stete) {
        this.stete = stete;
    }

    public Date getPlacedTime() {
        return placedTime;
    }

    public void setPlacedTime(Date placedTime) {
        this.placedTime = placedTime;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public double getNet() {
        return net;
    }

    public void setNet(double net) {
        this.net = net;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(String levelCode) {
        this.levelCode = levelCode;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public double getOptionPrice() {
        return optionPrice;
    }

    public void setOptionPrice(double optionPrice) {
        this.optionPrice = optionPrice;
    }

    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    public boolean getCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
