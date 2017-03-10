/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-01-07
 */


package com.beautifulchina.dao.customline;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.customline.bo.CustomlineBO;
import com.beautifulchina.customline.pojo.Customline;
import com.beautifulchina.destinationday.bo.DestinationDayBO;
import com.beautifulchina.destinationday.pojo.DestinationDay;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2016/1/6.
 * 定制线路
 */

@Repository
public interface CustomlineMapper extends SqlMapper {
    /**
     * 获取定制线路总数
     */
    int getCustomlineCount(CustomlineBO customlineBO);

    /**
     * 获取所有用户
     */
    List<Customline> getAllUser(CustomlineBO customlineBO);


    /**
     * 更新平台用户信息
     */
    void updateCustomline(Customline customline);



    /**
     * 获取城市名和旅游天数总数
     */
    int getDestinationDayCount(DestinationDayBO destinationDayBO);

    /**
     * 获取城市名和旅游天数
     */
    List<DestinationDay> getAll(DestinationDayBO destinationDayBO);


    /**
     * 更新城市名和旅游天数
     */
    void updateDestinationDay(DestinationDay destinationDay);


    /**
     * 根据定制线路ID删除城市名和旅游天数
     */
    void delete(List<String> ids);


    /**
     * 获取城市列表
     * @return
     */
    List<Map<String,String>> getCity();


    /**
     * 新增目的地信息
    */
    Integer addDestinationDay(DestinationDayBO destinationdayBO);

}
