/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-11
 */

package com.beautifulchina.consultive.bo;

import com.beautifulchina.consultive.vo.ConsultiveVO;

import java.util.Date;

/**
 * 咨询管理咨询管理
 */
public class ConsultiveBO extends ConsultiveVO {
    /**
     * 操作时间
     */
    private Date operateTime;
    /**
     * 操作人
     */
    private String operator;

    public Date getOperateTime() {  return operateTime;}

    public void setOperateTime(Date operateTime) { this.operateTime = operateTime; }

    public String getOperator() { return operator;}

    public void setOperator(String operator) { this.operator = operator;}

}
