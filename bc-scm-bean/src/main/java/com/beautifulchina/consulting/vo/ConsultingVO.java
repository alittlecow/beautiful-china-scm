/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-18
 */

package com.beautifulchina.consulting.vo;

import com.beautifulchina.common.PageQuery;

import java.util.Date;

/**
 * 咨询投诉管理
 */
public class ConsultingVO extends PageQuery {
    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * email
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 状态
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 处理人员
     */
    private Integer passId;

    /**
     * 处理时间
     */
    private Date dealTime;

    /**
     * 内容
     */
    private String content;

    /**
     *处理结果
     */
    private String deal;

    /**
     * id
     */
    private Integer id;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getDeal() { return deal; }

    public void setDeal(String deal) { this.deal = deal; }

    public String getName() { return name;  }

    public void setName(String name) { this.name = name; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getPassId() {
        return passId;
    }

    public void setPassId(Integer passId) {
        this.passId = passId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
