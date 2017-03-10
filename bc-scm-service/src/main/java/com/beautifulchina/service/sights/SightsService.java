/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-05
 */
package com.beautifulchina.service.sights;

import com.beautifulchina.base.Page;
import com.beautifulchina.dao.sights.SightsMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.sights.bo.SightsBO;
import com.beautifulchina.sights.pojo.Sights;
import com.beautifulchina.sights.vo.SightsVO;
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
 * 景点管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SightsService {
    @Autowired
    private SightsMapper sightsMapper;

    /**
     * 获取景点信息
     * @param sightsVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<SightsBO> getSights(SightsVO sightsVO) {
        SightsBO sightsBO=new SightsBO();
        BeanUtils.copyProperties(sightsVO,sightsBO);
        int count=sightsMapper.getCount(sightsBO);
        Page<SightsBO> page=new Page<SightsBO>();
        List<SightsBO> list=new ArrayList<SightsBO>();
        if(count>0){
            List<Sights> sightsList=sightsMapper.getSights(sightsBO);
            if(!CollectionUtils.isEmpty(sightsList)){
                for(Sights sights:sightsList){
                    SightsBO sightsBO1=new SightsBO();
                    BeanUtils.copyProperties(sights,sightsBO1);
                    list.add(sightsBO1);
                }
                page.setTotal(count);
                page.setData(list);
            }
        }
        return page;
    }

    /**
     * 删除景点信息
     * @param ids
     */
    public void delSights(String[] ids){
        List<String> list = CollectionUtils.arrayToList(ids);
        sightsMapper.delSights(list);
    }

    /**
     * 新增景点信息
     * @param sightsVO
     * @throws RedisException
     */
    public void addSights(SightsVO sightsVO) throws RedisException {
        SightsBO sightsBO=new SightsBO();
        BeanUtils.copyProperties(sightsVO,sightsBO);
        sightsBO.setLevel("todo");
        sightsMapper.addSights(sightsBO);
    }

    /**
     * 更新景点信息
     * @param sightsVO
     */
    public void updSights(SightsVO sightsVO){
        SightsBO sightsBO=new SightsBO();
        BeanUtils.copyProperties(sightsVO,sightsBO);
        sightsMapper.updSights(sightsBO);
    }
    /**
     * 获取目的地城市列表
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<Map<String, String>> getDesCity(String language) {
        List<Map<String, String>> list = sightsMapper.getDesCity(language);
        return list;
    }
}
