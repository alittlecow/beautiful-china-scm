/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2016-01-05
 */
package com.beautifulchina.common.bo;

import com.beautifulchina.common.vo.CityQueryVO;

/**
 * 城市查询BO
 */
public class CityQueryBO extends CityQueryVO {
    /**
     * 法文名
     */
    private String cityNameFr;
    /**
     * 英文名
     */
    private String cityNameEn;

    public String getCityNameFr() {
        return cityNameFr;
    }

    public void setCityNameFr(String cityNameFr) {
        this.cityNameFr = cityNameFr;
    }

    public String getCityNameEn() {
        return cityNameEn;
    }

    public void setCityNameEn(String cityNameEn) {
        this.cityNameEn = cityNameEn;
    }
}
