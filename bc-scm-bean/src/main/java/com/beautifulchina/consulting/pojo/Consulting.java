/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-18
 */

package com.beautifulchina.consulting.pojo;

import com.beautifulchina.consulting.bo.ConsultingBO;

/**
 * 咨询投诉管理
 */
public class Consulting extends ConsultingBO {
    /**
     * 类型代码pojo
     */
    private String inputType;

    /**
     * 状态代码pojo
     */
    private String inputStatus;

    /**
     * 提交时间代码pojo
     */
    private String inputSubmitTime;

    public String getInputType() { return inputType; }

    public void setInputType(String inputType) { this.inputType = inputType; }

    public String getInputSubmitTime() { return inputSubmitTime; }

    public void setInputSubmitTime(String inputSubmitTime) { this.inputSubmitTime = inputSubmitTime; }

    public String getInputStatus() { return inputStatus; }

    public void setInputStatus(String inputStatus) { this.inputStatus = inputStatus; }
}
