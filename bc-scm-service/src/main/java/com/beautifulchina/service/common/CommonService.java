/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-25
 */
package com.beautifulchina.service.common;

import com.beautifulchina.city.bo.CityBO;
import com.beautifulchina.city.pojo.City;
import com.beautifulchina.common.Page;
import com.beautifulchina.common.bo.CityQueryBO;
import com.beautifulchina.common.vo.CityQueryVO;
import com.beautifulchina.dao.common.CommonMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 公共服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CommonService {

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 查询城市列表
     * @param cityQueryVO
     * @return
     */
    public Page<CityBO> queryCityList(CityQueryVO cityQueryVO, String language){
        CityQueryBO cityQueryBO = new CityQueryBO();
        BeanUtils.copyProperties(cityQueryVO,cityQueryBO);
        // 根据前端语言类型查询对应的字段
        if("fr".equals(language)){
            cityQueryBO.setCityNameFr(cityQueryVO.getQuery());
        }else{
            cityQueryBO.setCityNameEn(cityQueryVO.getQuery());
        }

        int count = commonMapper.queryCityListCount(cityQueryBO);

        List<CityBO> cityBOList = null;

        // 如果个数大于0查询所有城市
        if(count>0){
            List<City> cityList = commonMapper.queryCityList(cityQueryBO);

            // 根据前端的语言返回对应的字段
            if(!CollectionUtils.isEmpty(cityList)){
                cityBOList = new ArrayList<CityBO>();
                for (City city:cityList){
                    CityBO cityBO = new CityBO();
                    cityBO.setCityId(city.getCityId());
                    if("fr".equals(language)){
                        cityBO.setCityName(city.getCityNameFr());
                    }else {
                        cityBO.setCityName(city.getCityNameEn());
                    }
                    cityBOList.add(cityBO);
                }
            }
        }

        // 组织返回值
        Page<CityBO> page = new Page<CityBO>();
        page.setData(cityBOList);
        page.setTotal(count);
        return page;
    }
}
