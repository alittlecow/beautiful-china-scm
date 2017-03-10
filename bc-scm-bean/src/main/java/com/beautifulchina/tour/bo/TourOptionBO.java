/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-03-14
 */
package com.beautifulchina.tour.bo;

import com.beautifulchina.tour.vo.TourOptionVO;

public class TourOptionBO extends TourOptionVO {
    /**
     * 默认值
     */
    private Integer toleration;

    public Integer getToleration() {
        return toleration;
    }

    public void setToleration(Integer toleration) {
        this.toleration = toleration;
    }
}
