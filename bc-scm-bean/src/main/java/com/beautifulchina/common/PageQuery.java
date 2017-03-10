/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-18
 */
package com.beautifulchina.common;

import com.alibaba.fastjson.annotation.JSONField;
import com.beautifulchina.base.BaseBean;

/**
 * 分页查询公共类
 */
public class PageQuery extends BaseBean {
    /**
     * 起始数量
     */
    @JSONField(serialize = false)
    private int start;
    /**
     * 每页数量
     */
    @JSONField(serialize = false)
    private int limit;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
