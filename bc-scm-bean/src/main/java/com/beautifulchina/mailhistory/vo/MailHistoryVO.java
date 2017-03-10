/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.mailhistory.vo;

import com.beautifulchina.common.PageQuery;
/**
 * 邮件历史记录业务
 */
public class MailHistoryVO extends PageQuery {

    /**
     * 邮件历史id代码
     */
    private String id;

    /**
     * 标题代码
     */
    private String title;

    /**
     * 邮件内容代码
     */
    private String content;

    /**
     * 收件人id代码
     */
    private String userId;

    /**
     * 收件人email代码
     */
    private String email;

    /**
     * 邮件类型代码
     */
    private String type;

    /**
     * 关联单号代码
     */
    private String orderNo;

    /**
     * 发送时间代码
     */
    private String operateTime;


    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getOrderNo() { return orderNo; }

    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }

    public String getOperateTime() { return operateTime; }

    public void setOperateTime(String operateTime) { this.operateTime = operateTime; }
}
