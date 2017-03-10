/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-1-6
 */


package com.beautifulchina.customline.vo;

import com.beautifulchina.common.PageQuery;

import java.util.Date;

/**
 * Created by zhangyu on 2016/1/6.
 * 定制线路
 */
public class CustomlineVO  extends PageQuery {

    private Integer  id;
    /**
     *
     * 参加人数
     */
    private Integer person;

    /**
     *
     *抵达时间
     */
    private Date arriveTime;

    /**
     *
     *返程时间
     */
    private Date returnTime;

    /**
     *
     *酒店级别
     */
    private  Integer hotelLevel;


    /**
     *性别
     */
    private String sex;

    /**
     *
     *状态
     *N:未处理
     *S:处理完成
     */
    private String status;

    /**
     * 其他需求说明
     */
    private String otherRequirement;

    /**
     * 处理结果说明
     */

    private String result;


    /**
     * 操作人员id
     */
    private Integer passId;

    /**
     * 操作人员
     */
    private String passName;

    /**
     * 操作时间
     */
    private Date dealTime;

    /**
     *
     *姓名
     */
    private String name;

    /**
     *
     *创建时间
     */
    private Date createTime;

    /**
     *
     *创建时间上限
     */
    private Date createTimeBig;


    /**
     *
     *创建时间下限
     */
    private Date createTimeSmall;



    /**
     *
     * email
     */
    private String email;

    /**
     *
     * 电话
     */
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerson() {
        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    public Integer getHotelLevel() {
        return hotelLevel;
    }

    public void setHotelLevel(Integer hotelLevel) {
        this.hotelLevel = hotelLevel;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOtherRequirement() {
        return otherRequirement;
    }

    public void setOtherRequirement(String otherRequirement) {
        this.otherRequirement = otherRequirement;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getPassId() {
        return passId;
    }

    public void setPassId(Integer passId) {
        this.passId = passId;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }


    public Date getCreateTimeBig() {
        return createTimeBig;
    }

    public void setCreateTimeBig(Date createTimeBig) {
        this.createTimeBig = createTimeBig;
    }

    public Date getCreateTimeSmall() {
        return createTimeSmall;
    }

    public void setCreateTimeSmall(Date createTimeSmall) {
        this.createTimeSmall = createTimeSmall;
    }
}
