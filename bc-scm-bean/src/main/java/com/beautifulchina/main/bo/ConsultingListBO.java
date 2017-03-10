/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-18
 */

package com.beautifulchina.main.bo;

import com.beautifulchina.consulting.bo.ConsultingBO;

/**
 * 咨询投诉管理
 */
public class ConsultingListBO extends ConsultingBO {
    /**
     * 类型代码
     */
    private String type;

    /**
     * 状态代码
     */
    private String status;

    /**
     * 提交时间代码
     */
    private String submitTime;

    @Override
    public String getType() { return type; }

    @Override
    public void setType(String type) { this.type = type; }

    public String getSubmitTime() { return submitTime; }

    public void setSubmitTime(String submitTime) { this.submitTime = submitTime; }

    @Override
    public String getStatus() { return status;}

    public void setStatus(String status) { this.status = status; }
}
