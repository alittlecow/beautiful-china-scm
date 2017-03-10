/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.mailhistory.bo;


import com.beautifulchina.mailhistory.vo.MailHistoryVO;

import java.util.Date;

/**
 * 邮件历史记录咨询管理
 */
public class MailHistoryBO extends MailHistoryVO{
    /**
     * 操作时间
     */
    private Date operationTime;
    /**
     * 操作人
     */
    private String operator;

    public Date getOperationTime() { return operationTime; }

    public void setOperationTime(Date operationTime) { this.operationTime = operationTime; }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
