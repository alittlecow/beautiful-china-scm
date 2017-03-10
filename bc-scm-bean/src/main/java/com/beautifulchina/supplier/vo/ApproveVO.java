/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-23
 */
package com.beautifulchina.supplier.vo;
/**
 * 批量处理，供应商审批的类
 */

import com.beautifulchina.base.BaseBean;

public class ApproveVO extends BaseBean{
    /**
     * 审批id
     */
    private String ids;

    /**
     * 审批状态
     */
    private String status;
    /**
     * 驳回原因
     */
    private String rReason;

    /**
     * 审批人
     */
    private String approver;
    /**
     * 供应商id
     */
    private Integer supId;

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getrReason() {
        return rReason;
    }

    public void setrReason(String rReason) {
        this.rReason = rReason;
    }

}
