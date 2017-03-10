/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-03
 */
package com.beautifulchina.dao.hotel;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.hotel.bo.HotelBO;
import com.beautifulchina.hotel.pojo.Hotel;
import com.beautifulchina.hotel.vo.HotelVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 酒店管理dao
 */
@Repository
public interface HotelMapper extends SqlMapper {
    /**
     * 根据条件获取酒店信息
     *
     * @param hotelBO
     * @return
     */
    List<Hotel> getHotel(HotelBO hotelBO);

    /**
     * 获取酒店信息数量
     * @param hotelBO
     * @return
     */
    Integer getCount(HotelBO hotelBO);

    /**
     * 删除酒店信息
     * @param ids
     */
    void delHotel(List<String> ids);
    /**
     * 获取城市列表
     * @return
     */
    List<Map<String,String>> getCity(String language);
    /**
     * 获取供应商列表
     * @return
     */
    List<Map<String,String>> getSup(String language);

    /**
     * 新增酒店信息
     * @param hotelBO
     */
    void addHotel(HotelBO hotelBO);
    /**
     * 更新酒店信息
     * @param hotelBO
     */
    void updateHotel(HotelBO hotelBO);
}
