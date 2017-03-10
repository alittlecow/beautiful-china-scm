/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-17
 */
package com.beautifulchina.dao.menu;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.menu.bo.MenuBO;
import com.beautifulchina.menu.pojo.Menu;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单dao
 */
@Repository
public interface MenuMapper extends SqlMapper{
    /**
     * 获取用户拥有的菜单 TODO 暂未做权限
     * @param roleCode
     * @param plateId
     * @param moduleId
     * @return
     */
    public List<Menu> getMenuList(@Param(value = "roleCode")String roleCode,
                                  @Param(value = "plateId")String plateId,
                                  @Param(value = "moduleId")String moduleId,
                                  @Param(value = "language")String language);

    /**
     * 根据条件获取所有的菜单信息列表
     * @param menuBO
     * @return
     */
    public List<Menu> getAllMenuList(MenuBO menuBO);

    /**
     * 根据条件获取所有的模块信息列表
     * @param menuBO
     * @return
     */
    public List<Menu> getModuleByPlateCode(MenuBO menuBO);
    /**
     * 根据条件获取所有的菜单信息数量
     * @param menuBO
     * @return
     */
    public int getAllMenuListCount(MenuBO menuBO);

    /**
     * 保存菜单
     * @param menuBO
     */
    public void save(MenuBO menuBO);

    /**
     * 更新菜单
     * @param menuBO
     */
    public void update(MenuBO menuBO);

    /**
     * 根据菜单编号删除菜单
     * @param codes
     */
    public void delete(List<String> codes);
}
