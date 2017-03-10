/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-18
 */

package com.beautifulchina.consulting.bo;

import com.beautifulchina.consulting.vo.ConsultingVO;

import java.util.Date;

/**
 * 咨询投诉管理业务
 */
public class ConsultingBO extends ConsultingVO {
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 操作人
     */
    private String operator;

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
