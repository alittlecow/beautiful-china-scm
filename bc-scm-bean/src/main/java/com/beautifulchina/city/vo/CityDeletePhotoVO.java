/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-04-07
 */

package com.beautifulchina.city.vo;

import com.beautifulchina.base.BaseBean;

/**
 * 城市图片
 */
public class CityDeletePhotoVO  extends BaseBean {
    /**
     * 保存路径
     */
    private String savePath;
    /**
     * id
     */
    private Integer id;
    /**
     * 图片名称
     */
    private String photoName;

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }
}
