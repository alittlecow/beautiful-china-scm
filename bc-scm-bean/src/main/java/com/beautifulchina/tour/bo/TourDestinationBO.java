/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-02-04
 */
package com.beautifulchina.tour.bo;

import com.beautifulchina.base.BaseBean;

/**
 * 路线目的地业务
 */
public class TourDestinationBO extends BaseBean{
    /**
     * 线路id
     */
    private Integer tourId;
    /**
     * 目的地id
     */
    private Integer destId;

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getDestId() {
        return destId;
    }

    public void setDestId(Integer destId) {
        this.destId = destId;
    }
}
