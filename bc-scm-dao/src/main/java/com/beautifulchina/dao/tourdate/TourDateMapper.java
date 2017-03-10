/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-23
 */
package com.beautifulchina.dao.tourdate;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.tourdate.bo.TourDateBO;
import com.beautifulchina.tourdate.bo.TourDateQueryBO;
import com.beautifulchina.tourdate.pojo.TourDate;
import com.beautifulchina.tourdate.vo.TourDateVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 线路出发管理dao
 */
@Repository
public interface TourDateMapper extends SqlMapper{
    /**
     * 根据条件获取线路出发管理数据
     * @param tourDateBO
     * @return
     */
    List<TourDate> getTourDate(TourDateBO tourDateBO);

    /**
     * 根据条件获取所有信息数量
     * @param tourDateBO
     * @return
     */
    Integer getCount(TourDateBO tourDateBO);

    /**
     * 根据id批量删除线路出发管理信息
     * @param id
     */
    void delete(List<String> id);

    /**
     * 获取线路名称
     * @return
     */
    List<Map<String,String>> getTitle(TourDateQueryBO tourDateQueryBO);

    /**
     * 新增线路出团管理数据
     * @param tourDateBO
     */
    void addTourDate(List<TourDateBO> tourDateBO);

    /**
     * 更新线路出团信息
     * @param tourDateBO
     */
    void upDateTourDate(TourDateBO tourDateBO);

    /**
     * 获取用户路线id
     * @param deptCode
     * @return
     */
    List<Integer> getTourId(String deptCode);

}
