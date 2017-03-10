/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-03
 */
package com.beautifulchina.hotel.bo;

import com.beautifulchina.hotel.vo.HotelVO;

import java.util.Date;

/**
 * 酒店管理业务
 */
public class HotelBO extends HotelVO{
    /**
     * 时间
     */
    private Date createTime;
    /**
     * 操作人
     */
    private String user;
    /**
     * 酒店所在城市英
     */
    private String hotelCityEn;
    /**
     * 酒店所在城市英
     */
    private String hotelCityFr;

    /**
     * 酒店所在城市
     */
    private String hotelCity;

    public String getHotelCity() {
        return hotelCity;
    }

    public void setHotelCity(String hotelCity) {
        this.hotelCity = hotelCity;
    }

    public String getHotelCityFr() {
        return hotelCityFr;
    }

    public void setHotelCityFr(String hotelCityFr) {
        this.hotelCityFr = hotelCityFr;
    }

    public String getHotelCityEn() {
        return hotelCityEn;
    }

    public void setHotelCityEn(String hotelCityEn) {
        this.hotelCityEn = hotelCityEn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
