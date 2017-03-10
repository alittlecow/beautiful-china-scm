package com.beautifulchina.dao.city;


import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.city.bo.CityBO;
import com.beautifulchina.city.bo.CityDeletePhotoBO;
import com.beautifulchina.city.pojo.City;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by ZHF on 2016/1/6.
 */
@Repository
public interface CityMapper extends SqlMapper{

    /**
     * 查询城市
     * @param cityBO
     */
    public List<City> getAllCityList(CityBO cityBO);

    /**
     * 根据条件获取所有的城市信息数量
     * @param cityBO
     * @return
     */
    public int getAllCityListCount(CityBO cityBO);

    /**
     * 保存城市
     * @param cityBO
     */
    public void save(CityBO cityBO);

    /**
     * 更新城市
     * @param cityBO
     */
    public void update(CityBO cityBO);

    /**
     * 根据城市id删除城市
     * @param cityIds
     */
    public void delete(List<String> cityIds);

    /**
     * 根据cityIds获取图片名称
     * @param cityIds
     * @return
     */
    List<Map<String,String>> getPhotoNameById(List<String> cityIds);

    /**
     * 修改城市图片
     */
    void updPhoto(CityDeletePhotoBO cityDeletePhotoBO);
}
