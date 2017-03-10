/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2016-01-26
 */
package com.beautifulchina.linetheme.vo;

import com.beautifulchina.base.BaseBean;

/**
 * 目的地图片删除
 */
public class LineThemeDeletePhotoVO extends BaseBean{
    /**
     * 保存路径
     */
    private String savePath;
    /**
     * 主题id
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
