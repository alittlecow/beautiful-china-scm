/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.dao.rolemanage;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.menu.pojo.Menu;
import com.beautifulchina.menu.pojo.Module;
import com.beautifulchina.menu.pojo.Plate;
import com.beautifulchina.rolemanage.bo.RoleBO;
import com.beautifulchina.rolemanage.bo.RoleMenuBO;
import com.beautifulchina.rolemanage.pojo.Role;
import com.beautifulchina.rolemanage.vo.RoleVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色管理dao
 */
@Repository
public interface RoleManageMapper extends SqlMapper{
    /**
     * 分页获取所有用户
     * @param roleVO
     * @return
     */
    List<Role> getAllRole(RoleVO roleVO);

    /**
     * 获取所有角色代码和角色名称
     * @return
     */
    List<RoleBO> getAllRoleCodeAndName(RoleBO roleBO);

    /**
     * 根据用户角色代码获取用户模块
     * @param rolecode
     * @return
     */
    List<Module> getModuleListByRoleCode(String rolecode);

    /**
     * 获取所有模块
     * @param language
     * @return
     */
    List<Module> getModuleList(@Param(value = "language") String language);

    /**
     * 获取所有模板
     * @param language
     * @return
     */
    List<Plate> getPlateList(@Param(value = "language") String language);

    /**
     * 根据模块id获取菜单
     * @param language
     * @return
     */
    List<Menu> getMenuList(@Param(value = "language") String language);

    /**
     * 根据角色代码获取菜单
     * @param roleCode
     * @return
     */
    List<Menu> getMenuListByRoleCode(String roleCode);

    /**
     * 新增用户信息
     * @param userManage
     */
    void saveRole(Role userManage);

    /**
     * 编辑用户信息
     * @param userManage
     */
    void editRole(Role userManage);

    /**
     * 获取所有用户数量
     * @return
     */
    int getAllRoleCount();

    /**
     * 根据角色代码获取角色菜单
     * @param roleCode
     * @return
     */
    List<String> getRoleMenu(String roleCode);

    /**
     * 更新角色菜单
     * @param roleMenuBOList
     */
    void addRoleMenu(List<RoleMenuBO> roleMenuBOList);

    /**
     * 根据角色代码删除
     * @param roleCode
     */
    void delRoleMenu(String roleCode);

    /**
     * 根据角色代码获取角色信息
     * @param roleCode
     * @return
     */
    RoleBO getRoleByRoleCode(String roleCode);
}
