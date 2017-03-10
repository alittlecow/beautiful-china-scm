package com.beautifulchina.order.pojo;

/**
 * Created by ZHF on 2016/3/11.
 */
public class OrderPassenger {
    /**
     * id
     */
    private Integer id;

    /**
     * 订单号
     */
    private String orderNo;

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
}
