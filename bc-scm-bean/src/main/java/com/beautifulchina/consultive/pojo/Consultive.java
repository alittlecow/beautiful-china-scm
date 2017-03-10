/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-11
 */

package com.beautifulchina.consultive.pojo;

import com.beautifulchina.consultive.bo.ConsultiveBO;

/**
 * 咨询管理
 */
public class Consultive extends ConsultiveBO {
    /**
     * 线路名称
     */
    private Integer inputTourId;


    /**
     * 状态
     */
    private String inputStatus;

    public Integer getInputTourId() {  return inputTourId; }

    public void setInputTourId(Integer inputTourId) { this.inputTourId = inputTourId; }

    public String getInputStatus() { return inputStatus; }

    public void setInputStatus(String inputStatus) { this.inputStatus = inputStatus; }
}
