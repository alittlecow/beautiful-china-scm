/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2016-01-05
 */
package com.beautifulchina.common.vo;

import com.beautifulchina.base.Base;
import com.beautifulchina.common.PageQuery;

/**
 * 城市查询Bean
 */
public class CityQueryVO extends PageQuery {
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
