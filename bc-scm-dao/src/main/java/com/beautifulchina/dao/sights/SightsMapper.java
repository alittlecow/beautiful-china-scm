/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-05
 */
package com.beautifulchina.dao.sights;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.sights.bo.SightsBO;
import com.beautifulchina.sights.pojo.Sights;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 景点管理dao
 */
@Repository
public interface SightsMapper extends SqlMapper{
    /**
     * 获取景点信息
     * @param sightsBO
     * @return
     */
    List<Sights> getSights(SightsBO sightsBO);

    /**
     * 获取景点信息数量
     * @param sightsBO
     * @return
     */
    Integer getCount(SightsBO sightsBO);

    /**
     * 删除景点信息
     * @param ids
     */
    void delSights(List<String> ids);

    /**
     * 新增景点信息
     * @param sightsBO
     */
    void addSights(SightsBO sightsBO);

    /**
     * 更新景点信息
     * @param sightsBO
     */
    void updSights(SightsBO sightsBO);
    /**
     * 获取目的地城市列表
     * @return
     */
    List<Map<String,String>> getDesCity(String language);
}
