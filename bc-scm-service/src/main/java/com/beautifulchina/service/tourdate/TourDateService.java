/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-23
 */
package com.beautifulchina.service.tourdate;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.tour.TourMapper;
import com.beautifulchina.dao.tourdate.TourDateMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.tour.pojo.Tour;
import com.beautifulchina.tourdate.bo.TourDateBO;
import com.beautifulchina.tourdate.bo.TourDateQueryBO;
import com.beautifulchina.tourdate.pojo.TourDate;
import com.beautifulchina.tourdate.vo.TourDateVO;
import com.beautifulchina.user.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * 线路出发管理相关业务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TourDateService {
    @Autowired
    private TourDateMapper tourDateMapper;

    /**
     * 根据条件获取线路出发管理数据
     *
     * @param tourDateBO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<TourDateBO> getTourDate(TourDateBO tourDateBO, UserBO userBO) {
        if ("SUPPLIER".equalsIgnoreCase(userBO.getDeptInfoBO().getLevelCode())) {
            List<Integer> list = tourDateMapper.getTourId(userBO.getDeptInfoBO().getDeptCode());
            if(list.size()==0){
                list.add(-1);
            }
            tourDateBO.setIdList(list);
        }
        Integer count = tourDateMapper.getCount(tourDateBO);
        Page<TourDateBO> page = new Page<TourDateBO>();
        List<TourDateBO> tourDateBOList = new ArrayList<TourDateBO>();
        if (count > 0) {
            List<TourDate> list = tourDateMapper.getTourDate(tourDateBO);
            for (TourDate tourDate : list) {
                TourDateBO tourDateBO1 = new TourDateBO();
                BeanUtils.copyProperties(tourDate, tourDateBO1);
                tourDateBOList.add(tourDateBO1);
            }
        }
        page.setTotal(count);
        page.setData(tourDateBOList);
        return page;
    }

    /**
     * 根据id删除线路出发管理信息
     *
     * @param id
     */
    public void delete(String[] id) {
        List<String> list = CollectionUtils.arrayToList(id);
        tourDateMapper.delete(list);
    }

    /**
     * 获取线路名称
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<Map<String, String>> getTitle(String language,UserBO userBO) {
        TourDateQueryBO tourDateQueryBO=new TourDateQueryBO();
        if ("SUPPLIER".equalsIgnoreCase(userBO.getDeptInfoBO().getLevelCode())) {
            List<Integer> list = tourDateMapper.getTourId(userBO.getDeptInfoBO().getDeptCode());
            if(list.size()==0){
                list.add(-1);
            }
            tourDateQueryBO.setIdList(list);
        }
        tourDateQueryBO.setLanguage(language);
        List<Map<String, String>> list = tourDateMapper.getTitle(tourDateQueryBO);
        Page<Map<String, String>> page = new Page<Map<String, String>>();
        page.setData(list);
        return page;
    }

    /**
     * 新增线路出团管理数据
     *
     * @param tourDateVO
     */
    public void addTourDate(TourDateVO tourDateVO) throws RedisException {
        TourDateBO tourDateBO = new TourDateBO();
        BeanUtils.copyProperties(tourDateVO, tourDateBO);
        tourDateBO.setPending(0);
        tourDateBO.setSales(0);
        tourDateBO.setRemain(tourDateBO.getInventory());
        List<TourDateBO> list = new ArrayList<TourDateBO>();
        List<Date> dates = new ArrayList<Date>();
        //存储方式
        String[] types = {"week", "month"};
        String type = tourDateBO.getType();
        //存储序列
        List<Integer> dateIndexs = tourDateBO.getDateIndex();
        //起始时间
        Date startTime = tourDateBO.getStartTime();
        //结束时间
        Date endTime = tourDateBO.getEndTime();
        long DAY = 24 * 60 * 60 * 1000;
        //日期相差天数
        int days = (int) ((endTime.getTime() - startTime.getTime()) / DAY);
        for (int i = 0; i <= days; i++) {
            dates.add(new Date(startTime.getTime() + DAY * i));
        }
        //按周
        if (types[0].equals(type)) {
            checkDate(dates, dateIndexs, type);
        }
        //按月
        if (types[1].equals(type)) {
            checkDate(dates, dateIndexs, type);
        }
        if (dates.size() > 0) {
            for (Date date : dates) {
                TourDateBO tourBO = new TourDateBO();
                BeanUtils.copyProperties(tourDateBO, tourBO);
                tourBO.setTime(date);
                list.add(tourBO);
            }
            tourDateMapper.addTourDate(list);
        }
    }

    /**
     * 按类型，找出符合日期
     *
     * @param dates
     * @param dateIndexs
     * @param type
     */
    public void checkDate(List<Date> dates, List<Integer> dateIndexs, String type) {
        Calendar calendar = Calendar.getInstance();
        int dateType = Calendar.DATE;
        if ("week".equals(type)) {
            dateType = Calendar.DAY_OF_WEEK;
        }
        Iterator<Date> iterator = dates.iterator();
        Date date;
        boolean flag;
        while (iterator.hasNext()) {
            date = iterator.next();
            calendar.setTime(date);
            flag = true;
            for (Integer index : dateIndexs) {
                if (calendar.get(dateType) == index) {
                    flag = false;
                }
            }
            if (flag) {
                iterator.remove();
            }
        }
    }

    /**
     * 更新线路出团信息
     *
     * @param tourDateVO
     */
    public void upDateTourDate(TourDateVO tourDateVO) {
        TourDateBO tourDateBO = new TourDateBO();
        BeanUtils.copyProperties(tourDateVO, tourDateBO);
        tourDateMapper.upDateTourDate(tourDateBO);
    }
}
