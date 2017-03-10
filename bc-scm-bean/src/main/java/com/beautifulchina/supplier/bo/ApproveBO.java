/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-23
 */
package com.beautifulchina.supplier.bo;
/**
 * 批量处理，供应商审批的类
 */

import com.beautifulchina.supplier.vo.ApproveVO;

import java.util.Date;
import java.util.List;

public class ApproveBO extends ApproveVO {

    /**
     * 审批id的list表现形式
     */
    private List listIds;

    /**
     * 审批时间
     */
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List getListIds() {
        return listIds;
    }

    public void setListIds(List listIds) {
        this.listIds = listIds;
    }
}
