/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-04
 */
package com.beautifulchina.service.hotel;

import com.beautifulchina.base.Page;
import com.beautifulchina.dao.hotel.HotelMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.hotel.bo.HotelBO;
import com.beautifulchina.hotel.pojo.Hotel;
import com.beautifulchina.hotel.vo.HotelVO;
import com.beautifulchina.user.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 酒店管理相关业务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class HotelService {
    @Autowired
    private HotelMapper hotelMapper;

    /**
     * 获取酒店信息
     *
     * @param hotelVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<HotelBO> getHotel(HotelVO hotelVO) {
        HotelBO hotelBO = new HotelBO();
        BeanUtils.copyProperties(hotelVO, hotelBO);
        Integer count = hotelMapper.getCount(hotelBO);
        List<HotelBO> list = new ArrayList<HotelBO>();
        Page<HotelBO> page = new Page<HotelBO>();
        if (count > 0) {
            List<Hotel> hotelList = hotelMapper.getHotel(hotelBO);
            for (Hotel hotel : hotelList) {
                HotelBO hotelBO1 = new HotelBO();
                BeanUtils.copyProperties(hotel, hotelBO1);
                list.add(hotelBO1);
            }
            page.setData(list);
            page.setTotal(count);
        }

        return page;
    }

    /**
     * 删除酒店信息
     * @param ids
     */
    public void delHotel(String[] ids){
        List<String> list = CollectionUtils.arrayToList(ids);
        hotelMapper.delHotel(list);
    }
    /**
     * 获取城市列表
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getCity(String language) {
        List<Map<String, String>> list = hotelMapper.getCity(language);
        return list;
    }
    /**
     * 获取供应商列表
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getSup(String language) {
        List<Map<String, String>> list = hotelMapper.getSup(language);
        return list;
    }

    /**
     * 新增酒店信息
     * @param hotelVO
     */
    public void addHotel(HotelVO hotelVO,UserBO userBO)throws RedisException {
        HotelBO hotelBO=new HotelBO();
        BeanUtils.copyProperties(hotelVO, hotelBO);
        hotelBO.setCreateTime(new Date());
        hotelBO.setUser(userBO.getUsername());
        hotelMapper.addHotel(hotelBO);
    }
    /**
     * 更新酒店信息
     * @param hotelVO
     */
    public void updateHotel(HotelVO hotelVO,UserBO userBO){
        HotelBO hotelBO=new HotelBO();
        BeanUtils.copyProperties(hotelVO, hotelBO);
        hotelBO.setCreateTime(new Date());
        hotelBO.setUser(userBO.getUsername());
        hotelMapper.updateHotel(hotelBO);
    }

}
