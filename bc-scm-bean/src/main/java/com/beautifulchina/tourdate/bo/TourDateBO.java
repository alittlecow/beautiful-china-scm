/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-23
 */
package com.beautifulchina.tourdate.bo;

import com.beautifulchina.tourdate.vo.TourDateVO;

import java.util.Date;
import java.util.List;

/**
 * 线路出发业务
 */
public class TourDateBO extends TourDateVO {
    /**
     * 线路名称
     */
    private String title;
    /**
     * 线路英语名称
     */
    private String titleEn;
    /**
     * 线路法语名称
     */
    private String titleFr;
    /**
     * 批量存储时间
     */
    private List<Date> date;
    private List<Integer> idList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public List<Date> getDate() {
        return date;
    }

    public void setDate(List<Date> date) {
        this.date = date;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleFr() {
        return titleFr;
    }

    public void setTitleFr(String titleFr) {
        this.titleFr = titleFr;
    }
}
