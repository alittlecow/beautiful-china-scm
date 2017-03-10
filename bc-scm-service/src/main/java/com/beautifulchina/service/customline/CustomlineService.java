/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-1-8
 */
package com.beautifulchina.service.customline;
import com.beautifulchina.common.Page;
import com.beautifulchina.customline.pojo.Customline;
import com.beautifulchina.dao.customline.CustomlineMapper;
import com.beautifulchina.customline.bo.CustomlineBO;
import com.beautifulchina.customline.vo.CustomlineVO;
import com.beautifulchina.destinationday.bo.DestinationDayBO;
import com.beautifulchina.destinationday.pojo.DestinationDay;
import com.beautifulchina.destinationday.vo.DestinationDayVO;
import com.beautifulchina.exception.RedisException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 定制线路服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CustomlineService {

    @Autowired
    private CustomlineMapper customlineMapper;


    /**
     * 定制线路列表
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public Page<CustomlineBO> getCustomlineExtjsList(CustomlineVO customlineVO){
        CustomlineBO customlineBO = new CustomlineBO();
        BeanUtils.copyProperties(customlineVO, customlineBO);
        int count = customlineMapper.getCustomlineCount(customlineBO);
        List<CustomlineBO> customlineListBOList = new ArrayList<CustomlineBO>();
        Page<CustomlineBO> customlineListBOPage = new Page<CustomlineBO>();
        if (count > 0) {
            List<Customline> customlineList = customlineMapper.getAllUser(customlineBO);

            if (!CollectionUtils.isEmpty(customlineList)) {
                for (Customline customline : customlineList) {
                    CustomlineBO customlineBo = new CustomlineBO();
                    customline.setPassName(customlineVO.getPassName());
                    customline.setPassId(customlineVO.getPassId());
                    customline.setDealTime(customlineVO.getDealTime());
                    BeanUtils.copyProperties(customline, customlineBo);
                    customlineListBOList.add(customlineBo);
                }
            }
        }
        customlineListBOPage.setTotal(count);
        customlineListBOPage.setData(customlineListBOList);
        return customlineListBOPage;

    }


    /**
     *  更改定制线路信息
     */
    public void updateCustomline(Customline customline){

        customlineMapper.updateCustomline(customline);

    }


    /**
     * 获取城市名和旅游天数
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public Page<DestinationDayBO> getDestinationdayExtjsList(DestinationDayVO destinationDayVO){
        DestinationDayBO destinationDayBO = new DestinationDayBO();
        BeanUtils.copyProperties(destinationDayVO, destinationDayBO);
        int count = customlineMapper.getDestinationDayCount(destinationDayBO);
        List<DestinationDayBO> destinationDayListBOList = new ArrayList<DestinationDayBO>();
        Page<DestinationDayBO> destinationDayListBOPage = new Page<DestinationDayBO>();
        if (count > 0) {
            List<DestinationDay> destinationDayList = customlineMapper.getAll(destinationDayBO);
            if (!CollectionUtils.isEmpty(destinationDayList)) {
                for (DestinationDay destinationDay : destinationDayList) {
                    DestinationDayBO destinationDayBo = new DestinationDayBO();
                    BeanUtils.copyProperties(destinationDay, destinationDayBo);
                    destinationDayListBOList.add(destinationDayBo);
                }
            }
        }
        destinationDayListBOPage.setTotal(count);
        destinationDayListBOPage.setData(destinationDayListBOList);
        return destinationDayListBOPage;

    }


    /**
     *  更改城市名和旅游天数
     */
    public void updateDestinationDay(DestinationDay destinationDay){
        customlineMapper.updateDestinationDay(destinationDay);

    }

    /**
     * 根据编号删除城市名和旅游天数
     *
     */
    public void delete(String ids){
        List<String> list = CollectionUtils.arrayToList(ids.split(","));
        if(null !=list && !list.isEmpty()) {
            customlineMapper.delete(list);
        }
    }



    /**
     * 获取城市列表
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getCity() {
        List<Map<String, String>> list = customlineMapper.getCity();
        return list;
    }




    /**
     * 新增城市名和旅游天数
    */
    public void addDestinationDay(DestinationDayVO destinationDayVO) throws RedisException {
        DestinationDayBO destinationDayBO = new DestinationDayBO();
        BeanUtils.copyProperties(destinationDayVO,destinationDayBO);
        customlineMapper.addDestinationDay(destinationDayBO);
    }



}
