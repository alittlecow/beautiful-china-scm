/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-02
 */
package com.beautifulchina.base;

import java.util.List;

/**
 * 分页查询数据封装
 */
public class Page<T> {
    /**
     * 页码
     */
    private int pageNo;

    /**
     * 每页显示个数
     */
    private int pageSize;

    /**
     * 总个数
     */
    private long total;

    /**
     * 数据
     */
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
