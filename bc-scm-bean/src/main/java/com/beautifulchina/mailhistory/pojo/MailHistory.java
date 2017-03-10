/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.mailhistory.pojo;

import com.beautifulchina.mailhistory.bo.MailHistoryBO;
/**
 * 邮件历史记录POJO
 */
public class MailHistory extends MailHistoryBO {
    /**
     * 收件人地址
     */
    private String inputEmail;

    /**
     * 关联单号
     */
    private String inputOrderNo;

    public String getInputEmail() { return inputEmail; }

    public void setInputEmail(String inputEmail) { this.inputEmail = inputEmail; }

    public String getInputOrderNo() { return inputOrderNo; }

    public void setInputOrderNo(String inputOrderNo) { this.inputOrderNo = inputOrderNo; }
}
