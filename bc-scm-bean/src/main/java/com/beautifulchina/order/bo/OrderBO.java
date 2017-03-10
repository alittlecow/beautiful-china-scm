/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-20
 */
package com.beautifulchina.order.bo;

import com.beautifulchina.order.vo.OrderVO;

import java.util.Date;

/**
 * 订单
 */
public class OrderBO extends OrderVO {
    /**
     * 历史记录id
     */
    private Integer id;

    /**
     * 操作时间
     */
    private Date operateTime;

    /**
     * 操作人id
     */
    private int passId;

    /**
     * 操作人
     */
    private String operator;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
