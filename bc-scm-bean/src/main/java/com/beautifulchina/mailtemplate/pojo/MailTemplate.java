/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-26
 */
package com.beautifulchina.mailtemplate.pojo;


import com.beautifulchina.mailtemplate.bo.MailTemplateBO;

import java.util.Date;

/**
 * 邮件模板业务
 */
public class MailTemplate extends MailTemplateBO {

    /**
     *操作时间
     */
    private Date operateTime;

    /**
     *操作人id
     */
    private int passId;

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public int getPassId() {
        return passId;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }
}
