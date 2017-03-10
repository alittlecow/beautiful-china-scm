/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-04-07
 */
package com.beautifulchina.tour.bo;

/**
 * 线路途径城市业务
 */
public class TourWayCityBO {
    /**
     * 线路id
     */
    private Integer tourId;
    /**
     * 城市id
     */
    private Integer cityId;

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
