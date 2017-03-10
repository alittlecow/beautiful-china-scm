/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-01-14
 */


package com.beautifulchina.display.bo;

import com.beautifulchina.display.vo.DisplayVO;

/**
 * Created by zhangyu on 2016/1/14.
 * 首页显示配置
 */
public class DisplayBO extends DisplayVO {
    /**
     * 当日价格
     */
    private Double trdPrice;
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Double getTrdPrice() {
        return trdPrice;
    }

    public void setTrdPrice(Double trdPrice) {
        this.trdPrice = trdPrice;
    }


}