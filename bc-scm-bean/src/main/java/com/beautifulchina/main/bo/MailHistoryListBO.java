/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.mailhistory.vo.MailHistoryVO;

/**
 * 邮件历史记录bean
 */
public class MailHistoryListBO extends MailHistoryVO{
    /**
     * 收件人地址
     */
    private String email;

    /**
     * 关联单号
     */
    private String orderNo;


    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

//    @Override
//    public String getOrderNo() { return orderNo; }
//
//    @Override
//    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }
}
