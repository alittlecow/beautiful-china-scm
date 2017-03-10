/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-12-31
 */
package com.beautifulchina.dao.common;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.city.pojo.City;
import com.beautifulchina.common.bo.CityQueryBO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 公共的DAO
 */
@Repository
public interface CommonMapper extends SqlMapper{
    /**
     * 查询城市
     * @param params
     * @return
     */
    List<City> queryCityList(CityQueryBO params);

    /**
     * 查询城市个数
     * @param params
     * @return
     */
    int queryCityListCount(CityQueryBO params);

    /**
     * 获取当前序列
     * @return
     */
    int sequence();
}
