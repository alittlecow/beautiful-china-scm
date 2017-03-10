/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-07
 */
package com.beautifulchina.dao.destination;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.destination.bo.DestinationBO;
import com.beautifulchina.destination.bo.DestinationDeletePhotoBO;
import com.beautifulchina.destination.pojo.Destination;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 目的地管理dao
 */
@Repository
public interface DestinationMapper extends SqlMapper {
    /**
     * 获取目的地信息
     *
     * @param destinationBO
     * @return
     */
    List<Destination> getDestination(DestinationBO destinationBO);

    /**
     * 获取目的地信息学数量
     *
     * @param destinationBO
     * @return
     */
    Integer getCount(DestinationBO destinationBO);

    /**
     * 根据id删除目的地信息
     *
     * @param ids
     */
    void delDestination(List<String> ids);

    /**
     * 根据id删除目的地多语言信息
     *
     * @param id
     */
    void delDestinationLanguage(Integer id);

    /**
     * 新增目的地信息
     *
     * @param destinationBO
     */
    Integer addDestination(DestinationBO destinationBO);

    /**
     * 根据id更新目的地信息
     *
     * @param destinationBO
     */
    void updDestination(DestinationBO destinationBO);

    /**
     * 根据id获取图片名称
     *
     * @param ids
     * @return
     */
    List<Map<String, String>> getPhotoNameById(List<String> ids);

    /**
     * 修改目的地图片
     *
     * @param destinationDeletePhotoBO
     */
    void updPhoto(DestinationDeletePhotoBO destinationDeletePhotoBO);

    /**
     * 根据id获取目的地信息
     *
     * @param destinationBO
     * @return
     */
    List<Map<String, String>> getDestinationById(DestinationBO destinationBO);
}
