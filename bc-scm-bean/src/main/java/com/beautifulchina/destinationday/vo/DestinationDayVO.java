/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-01-08
 */
package com.beautifulchina.destinationday.vo;
import com.beautifulchina.common.PageQuery;


/**
 * Created by zhangyu on 2016/1/8.
 * 定制线路目的地
 */
public class DestinationDayVO extends PageQuery {
    /**
     * 定制线路id
     */
    private Integer cstId;
    /**
     * 城市id
     */
    private Integer cityId;
    /**
     * 旅游天数
     */
    private Integer day;
    /**
     *城市名英文
     */
    private String cityNameEn;

    public Integer getCstId() {
        return cstId;
    }

    public void setCstId(Integer cstId) {
        this.cstId = cstId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }
}


