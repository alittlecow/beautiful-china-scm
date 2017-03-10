/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-1-14
 */


package com.beautifulchina.dao.display;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.display.bo.DisplayBO;
import com.beautifulchina.display.pojo.Display;
import com.beautifulchina.indexconfig.bo.IndexConfigBO;
import com.beautifulchina.indexconfig.pojo.IndexConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangyu on 2016/1/14.
 * 首页展示项
 */

@Repository
public interface DisplayMapper extends SqlMapper {

    /**
     * 获取出团信息总数
     *
     * @param DisplayBO
     * @return
     */
    int selectTourDateCount(DisplayBO DisplayBO);

    /**
     * 获取出团信息列表
     *
     * @param DisplayBO
     * @return
     */
    List<Display> selectTourDate(DisplayBO DisplayBO);

    /**
     * 根据id获取线路图片
     *
     * @param id
     * @return
     */
    List<String> selectTourImages(@Param(value = "id") Integer id);

    /**
     * 获取页面banner配置值
     *
     * @return
     */
    List<IndexConfig> selectDisplayBanner();

    /**
     * 获取页面tour配置值
     *
     * @return
     */
    List<IndexConfig> selectDisplayTour(@Param(value = "language")String language);

    /**
     * 获取页面trip配置值
     *
     * @return
     */
    List<IndexConfig> selectDisplayTrip(@Param(value = "language")String language);

    /**
     * 获取页面theme配置值
     *
     * @return
     */
    List<IndexConfig> selectDisplayTheme(@Param(value = "language")String language);

    /**
     * 获取页面city配置值
     *
     * @return
     */
    List<IndexConfig> selectDisplayCity(@Param(value = "language")String language);

    /**
     * 新增页面配置信息
     *
     * @param indexConfigBO
     */

    void insertItemData(IndexConfigBO indexConfigBO);

    /**
     * 修改页面配置信息
     *
     * @param indexConfigBO
     */
    void updateItemData(IndexConfigBO indexConfigBO);

    /**
     * 获取所有页面配置图片
     *
     * @return
     */
    List<String> selectAllImages();

    /**
     * 根据type获取itemId
     *
     * @param type
     * @return
     */
    List<Integer> selectItemIdByType(@Param(value = "type") String type,@Param(value = "id") Integer id);
}
