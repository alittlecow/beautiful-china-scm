/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-25
 */
package com.beautifulchina.dao.tour;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.tour.bo.TourBO;
import com.beautifulchina.tour.bo.TourDestinationBO;
import com.beautifulchina.tour.bo.TourWayCityBO;
import com.beautifulchina.tour.pojo.Tour;
import com.beautifulchina.tour.pojo.TourOption;
import com.beautifulchina.tourImage.bo.TourImageBO;
import com.beautifulchina.tourconfig.bo.TourConfigBO;
import com.beautifulchina.tourdetail.bo.TourDetailBO;
import com.beautifulchina.tourdetail.pojo.TourDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 线路管理dao
 */
@Repository
public interface TourMapper extends SqlMapper {
    /**
     * 根据条件获取线路信息
     *
     * @param tourBO
     * @return
     */
    List<Tour> getTour(TourBO tourBO);

    /**
     * 根据条件获取线路数量
     *
     * @param tourBO
     * @return
     */
    Integer getCount(TourBO tourBO);

    /**
     * 根据id批量删除旅游线路管理信息
     *
     * @param id
     */
    void deleteTour(List<String> id);

    /**
     * 根据id批量删除行程详情信息
     *
     * @param id
     */
    void delDetail(List<String> id);

    /**
     * 获取所有图片保存地址
     *
     * @param id
     */
    List<Map> selectImageById(List<String> id);

    /**
     * 获取所有行程详情
     *
     * @return
     */
    List<TourDetail> getTourDetail(Map<String, String> map);

    /**
     * 获取所有行程详情数量
     *
     * @return
     */
    Integer getTourDetailCount(Map<String, String> map);

    /**
     * 获取供应商代码及名称
     *
     * @return
     */
    List<Map<String, String>> getSup();

    /**
     * 获取线路主题
     *
     * @return
     */
    List<Map<String, String>> getTheme(String language);

    /**
     * 新增旅游信息
     *
     * @param tourBO
     */
    void insertTour(TourBO tourBO);

    /**
     * 新增旅游相关主题信息
     *
     * @param tourBO
     */
    void insertTourTheme(TourBO tourBO);

    /**
     * 新增旅游线路相关配置
     *
     * @param tourConfigBO
     */
    void insertTourConfig(List<TourConfigBO> tourConfigBO);

    /**
     * 新增旅游线路相关图片
     *
     * @param tourImageBOs
     */
    void insertImage(List<TourImageBO> tourImageBOs);

    /**
     * 根据tourId删除图片信息
     *
     * @param tourId
     */
    void deleteImageById(Integer tourId);

    /**
     * 根据id获取旅游线路信息
     *
     * @param id
     * @return
     */
    List<Tour> selectBaseInfoById(Integer id);

    /**
     * 更新旅游信息
     *
     * @param tourBO
     */
    void updateBaseInfo(TourBO tourBO);

    /**
     * 更新旅游线路配置信息
     *
     * @param tourConfigBO
     */
    void updateTourConfig(TourConfigBO tourConfigBO);

    /**
     * 新增详情信息
     *
     * @param tourDetailBO
     */
    void addDetail(TourDetailBO tourDetailBO);

    /**
     * 根据id更新已有详情信息
     *
     * @param tourDetailBO
     */
    void updateDetail(TourDetailBO tourDetailBO);

    /**
     * 根据用户名获取用户所有线路图片地址
     *
     * @param user
     * @return
     */
    List<Map<String, String>> getUserImage(String user);

    /**
     * 新增线路目的地
     *
     * @param list
     */
    void insertDestination(List<TourDestinationBO> list);

    /**
     * 新增线路途径城市
     *
     * @param list
     */
    void insertWayCity(List<TourWayCityBO> list);

    /**
     * 获取线路目的地id
     *
     * @param id
     * @return
     */
    List<Integer> getTourDestination(Integer id);

    /**
     * 根据id删除线路目的地
     *
     * @param id
     */
    void deleteTourDestination(Integer id);

    /**
     * 获取线路途经城市id
     *
     * @param id
     * @return
     */
    List<Integer> getTourWayCity(Integer id);

    /**
     * 根据id删除线路途经城市
     *
     * @param id
     */
    void deleteTourWayCity(Integer id);

    /**
     * 获取线路代码
     *
     * @return
     */
    Integer getTourCode(String code);

    /**
     * 根据线路id获取图片地址
     *
     * @param tourId
     * @return
     */
    List<Map> selectImageByTourId(Integer tourId);

    /**
     * 根据线路id获取选项
     *
     * @param id
     * @return
     */
    List<TourOption> selectTourOptionById(@Param(value = "id") Integer id, @Param(value = "language") String language);

    /**
     * 根据线路id获取选项数量
     *
     * @param id
     * @return
     */
    Integer selectTourOptionByIdCount(Integer id);

    /**
     * 根据线路id获取选项
     *
     * @param tourId,orderNo,language
     * @return
     */
    List<TourOption> getOptionValueByOrderNo(@Param(value = "tourId")Integer tourId,@Param(value = "orderNo")String orderNo,@Param(value = "language")String language);

    /**
     * 根据线路id获取选项数量
     *
     * @param tourId,orderNo
     * @return
     */
    Integer getOptionValueByOrderNoCount(@Param(value = "tourId")Integer tourId,@Param(value = "orderNo")String orderNo);

    /**
     * 获取所有选项
     *
     * @return
     */
    List<Map<String, String>> selectAllOption(@Param(value = "language") String language, @Param(value = "list") List<Integer> list);


    /**
     * 获取所有选项
     *
     * @return
     */
    List<Map<String, String>> selectAllOptionByTourId(@Param(value = "language") String language,@Param(value = "tourId") Integer tourId, @Param(value = "list") List<Integer> list);

    /**
     * 获取所有选项值
     *
     * @return
     */
    List<Map<String, String>> selectAllOptionByOrderNo(@Param(value = "language") String language,@Param(value = "tourId") Integer tourId, @Param(value = "list") List<Integer> list);
    /**
     * 根据选项id获取选项值
     *
     * @param id
     * @return
     */
    List<Map<String, String>> selectOptionValueById(@Param(value = "id") Integer id, @Param(value = "language") String language, @Param(value = "tourId") Integer tourId);

    List<Map<String, String>>selectOptionValueByOrderNo(@Param(value = "orderNo") String orderNo, @Param(value = "language") String language, @Param(value = "tourId") Integer tourId);
    /**
     * 根据选项id获取已用选项值
     *
     * @param id
     * @return
     */
    List<Map<String, String>> selectExistOptionValueById(@Param(value = "id") Integer id, @Param(value = "language") String language, @Param(value = "tourId") Integer tourId);


    /**
     * 根据选项id获取已用选项值
     *
     * @param id
     * @return
     */
    List<Map<String, String>> getExistOptionValueByOrderNo(@Param(value = "id") Integer id, @Param(value = "language") String language, @Param(value = "tourId") Integer tourId,@Param(value = "orderNo") String orderNo);

    /**
     * 根据路线id删除路线选项值
     *
     * @param id
     */
    void deleteTourOptionValue(List<Integer> id);

    /**
     * 根据路线id插入路线选项值
     *
     * @param map
     */
    void insertTourOptionValue(List<Map> map);
}
