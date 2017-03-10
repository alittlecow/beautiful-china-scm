/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-02-19
 */
package com.beautifulchina.tourdate.bo;

import java.util.List;

public class TourDateQueryBO {
    /**
     * 语言
     */
    private String language;
    /**
     * 线路id
     */
    private List<Integer> idList;

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
