/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-07
 */
package com.beautifulchina.destination.vo;

import com.beautifulchina.base.Base;

import java.util.List;

/**
 * 目的地删除
 */
public class DestinationDeleteVO extends Base {
    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
