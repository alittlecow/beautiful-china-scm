/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-18
 */
package com.beautifulchina.common;

import com.beautifulchina.base.BaseBean;

import java.util.List;

/**
 * 分页数据
 */
public class Page<T> extends BaseBean {

    /**
     * 数据
     */
    private List<T> data;

    /**
     * 总数量
     */
    private int total;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
