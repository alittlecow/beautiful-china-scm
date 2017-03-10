/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-22
 */

package com.beautifulchina.dao.linetheme;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.linetheme.bo.LineThemeBO;
import com.beautifulchina.linetheme.bo.LineThemeDeletePhotoBO;
import com.beautifulchina.linetheme.pojo.LineTheme;

import java.util.List;
import java.util.Map;

/**
 * 线路主题管理dao
 */
public interface LineThemeMapper extends SqlMapper {
    /**
     * 根据条件获取所有的菜单信息列表
     * @param linethemeBO
     * @return
     */
    public List<LineTheme> getAllLineThemeList(LineThemeBO linethemeBO);

    /**
     * 根据条件获取所有的菜单信息数量
     * @param linethemeBO
     * @return
     */
    public int getAllLineThemeListCount(LineThemeBO linethemeBO);

    /**
     * 保存菜单
     * @param linethemeBO
     */
    public void save(LineThemeBO linethemeBO);

    /**
     * 更新菜单
     * @param linethemeBO
     */
    public void update(LineThemeBO linethemeBO);

    /**
     * 根据id删除
     * @param ids
     */
    public void delete(List<String> ids);

    /**
     * 根据id获取图片名称
     * @param ids
     * @return
     */
    List<Map<String,String>> getPhotoNameById(List<String> ids);

    /**
     * 修改主题图片
     */
    void updPhoto(LineThemeDeletePhotoBO lineThemeDeletePhotoBO);
}
