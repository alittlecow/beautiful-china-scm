/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-11
 */

package com.beautifulchina.main.bo;

import com.beautifulchina.consultive.bo.ConsultiveBO;

/**
 * 咨询管理
 */
public class ConsultiveListBO extends ConsultiveBO {
    /**
     * 线路名称代码
     */
    private Integer tourId;


    /**
     * 状态代码
     */
    private String status;

    @Override
    public Integer getTourId() { return tourId;}

    @Override
    public void setTourId(Integer tourId) { this.tourId = tourId;}

    @Override
    public String getStatus() { return status;}

    @Override
    public void setStatus(String status) { this.status = status;}
}
