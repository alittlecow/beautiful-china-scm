/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-05
 */
package com.beautifulchina.city.bo;

import com.beautifulchina.city.vo.CityVO;

import java.util.Date;

/**
 * 城市
 */
public class CityBO extends CityVO {
    /**
     * 城市名称
     */
    private String cityName;

    @Override
    public String getCityName() {
        return super.getCityName();
    }

    @Override
    public void setCityName(String cityName) {
        super.setCityName(cityName);
    }

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
