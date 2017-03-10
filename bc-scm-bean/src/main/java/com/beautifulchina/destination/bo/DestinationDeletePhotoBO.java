/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-26
 */
package com.beautifulchina.destination.bo;

import com.beautifulchina.destination.vo.DestinationDeletePhotoVO;

/**
 * 删除目的地图片业务
 */
public class DestinationDeletePhotoBO extends DestinationDeletePhotoVO {
    /**
     * 图片1
     */
    private String photoOne;
    /**
     * 图片2
     */
    private String photoTwo;
    /**
     * 图片3
     */
    private String photoThree;
    /**
     * 图片4
     */
    private String photoFour;

    public String getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(String photoOne) {
        this.photoOne = photoOne;
    }

    public String getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(String photoTwo) {
        this.photoTwo = photoTwo;
    }

    public String getPhotoThree() {
        return photoThree;
    }

    public void setPhotoThree(String photoThree) {
        this.photoThree = photoThree;
    }

    public String getPhotoFour() {
        return photoFour;
    }

    public void setPhotoFour(String photoFour) {
        this.photoFour = photoFour;
    }
}
