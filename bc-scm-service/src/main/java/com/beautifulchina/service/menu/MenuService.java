/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-17
 */
package com.beautifulchina.service.menu;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.common.CommonMapper;
import com.beautifulchina.dao.menu.MenuMapper;
import com.beautifulchina.dao.menu.ModuleMapper;
import com.beautifulchina.dao.menu.PlateMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.main.bo.*;
import com.beautifulchina.manager.RedisManager;
import com.beautifulchina.menu.bo.MenuBO;
import com.beautifulchina.menu.pojo.Menu;
import com.beautifulchina.menu.pojo.Module;
import com.beautifulchina.menu.pojo.Plate;
import com.beautifulchina.menu.vo.MenuVO;
import com.beautifulchina.menu.vo.PlateVO;
import com.beautifulchina.user.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 菜单相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuService {
    @Autowired
    private PlateMapper plateMapper;

    @Autowired
    private ModuleMapper moduleMapper;

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private CommonMapper commonMapper;

    @Autowired
    private RedisManager redisManager;

    /**
     * 通过用户编号获取相关板块信息
     *
     * @param userId
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<PlateExtjsBO> getPlateExtjsList(String userId, String language, String roleCode) {
        List<Plate> plateList = plateMapper.getPlateList(language, roleCode);
        ArrayList<PlateExtjsBO> plateBOs = new ArrayList<PlateExtjsBO>();
        if (!CollectionUtils.isEmpty(plateList)) {
            for (Plate plate : plateList) {
                PlateExtjsBO plateBO = new PlateExtjsBO();
                // TODO 暂未做国际化支持
                plateBO.setTitle(plate.getPlateName());
                plateBO.setItemId(plate.getCode());
                plateBOs.add(plateBO);
            }
        }
        return plateBOs;
    }

    /**
     * @param userId
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<ModuleExtjsBO> getModuleList(String userId, String plateId, String language, String roleCode) {
        List<ModuleExtjsBO> moduleBOList = new ArrayList<ModuleExtjsBO>();
        List<Module> moduleList = moduleMapper.getModuleList(userId, plateId, language, roleCode);
        if (!CollectionUtils.isEmpty(moduleList)) {
            for (Module module : moduleList) {
                ModuleExtjsBO moduleBO = new ModuleExtjsBO();
                // TODO 暂未做国际化支持
                moduleBO.setTitle(module.getModuleName());
                moduleBO.setItemId(module.getCode());
                moduleBO.setXtype("maintree");
                moduleBOList.add(moduleBO);
            }
        }
        return moduleBOList;
    }


    /**
     * 获取用户菜单
     *
     * @param plateId
     * @param moduleId
     * @param roloCode
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<MenuExtjsBO> getMenu(String plateId, String moduleId, String roloCode, String language) {
        List<MenuExtjsBO> menuBOList = new ArrayList<MenuExtjsBO>();
        List<Menu> menuList = menuMapper.getMenuList(roloCode, plateId, moduleId, language);
        if (!CollectionUtils.isEmpty(menuList)) {
            for (Menu menu : menuList) {
                MenuExtjsBO menuBO = new MenuExtjsBO();
                // TODO 暂未做国际化支持
                menuBO.setText(menu.getMenuName());
                menuBO.setId(menu.getCode());
                menuBO.setLeaf(true);
                menuBO.setCls(menu.getLink());
                menuBOList.add(menuBO);
            }
        }
        return menuBOList;
    }

    /**
     * 根据条件获取所有菜单信息
     *
     * @param menuVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<MenuListBO> getAllMenuList(MenuVO menuVO) {
        MenuBO menuBO = new MenuBO();
        BeanUtils.copyProperties(menuVO, menuBO);
        int count = menuMapper.getAllMenuListCount(menuBO);
        List<MenuListBO> menuListBOList = new ArrayList<MenuListBO>();
        Page<MenuListBO> menuListBOPage = new Page<MenuListBO>();
        if (count > 0) {
            List<Menu> menuList = menuMapper.getAllMenuList(menuBO);
            if (!CollectionUtils.isEmpty(menuList)) {
                for (Menu menu : menuList) {
                    MenuListBO menuListBO = new MenuListBO();
                    BeanUtils.copyProperties(menu, menuListBO);
                    menuListBOList.add(menuListBO);
                }
            }
        }
        menuListBOPage.setTotal(count);
        menuListBOPage.setData(menuListBOList);
        return menuListBOPage;
    }

    /**
     * 根据条件获取所有模块信息
     *
     * @param menuVO
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<Menu> getModuleByPlateCode(MenuVO menuVO) {
        MenuBO menuBO = new MenuBO();
        BeanUtils.copyProperties(menuVO, menuBO);
        List<Menu> menuList = new ArrayList<Menu>();
        Page<Menu> menuListPage = new Page<Menu>();
        menuList = menuMapper.getModuleByPlateCode(menuBO);
        menuListPage.setData(menuList);
        return menuListPage;
    }

    /**
     * 获取所有的板块信息
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<PlateBO> getPlateList(PlateVO plateVO) {
        String language = plateVO.getLanguage();
        List<Plate> plateList = plateMapper.getPlateList(language, null);
        List<PlateBO> plateBOs = new ArrayList<PlateBO>();
        if (!CollectionUtils.isEmpty(plateList)) {
            for (Plate plate : plateList) {
                PlateBO plateBO = new PlateBO();
                BeanUtils.copyProperties(plate, plateBO);
                plateBOs.add(plateBO);
            }
        }
        Page<PlateBO> plateBOPage = new Page<PlateBO>();
        plateBOPage.setData(plateBOs);
        return plateBOPage;
    }

    /**
     * 获取所有模块
     *
     * @return
     */
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public Page<ModuleBO> getAllModuleList(String language) {
        List<ModuleBO> moduleBOList = new ArrayList<ModuleBO>();
        List<Module> moduleList = moduleMapper.getAllModuleList(language);
        if (!CollectionUtils.isEmpty(moduleList)) {
            for (Module module : moduleList) {
                ModuleBO moduleBO = new ModuleBO();

                BeanUtils.copyProperties(module, moduleBO);
                moduleBOList.add(moduleBO);
            }
        }
        Page<ModuleBO> page = new Page<ModuleBO>();
        page.setData(moduleBOList);
        return page;
    }

    /**
     * 保存菜单
     *
     * @param menuVO
     */
    public void saveMenu(MenuVO menuVO, UserBO userBO) throws RedisException {
        MenuBO menuBO = new MenuBO();
        BeanUtils.copyProperties(menuVO, menuBO);
        //long seq = redisManager.incr("sequence");
        int seq = commonMapper.sequence();
        StringBuffer code = new StringBuffer(menuVO.getModuleCode())
                .append("_")
                .append(seq);
        // 处理level
        StringBuffer level = new StringBuffer("0000");
        menuBO.setLevel(level.toString());
        menuBO.setCode(code.toString());
        menuBO.setOperateTime(new Date());
        menuBO.setOperator(userBO.getUsername());
        menuMapper.save(menuBO);
    }

    /**
     * 更新菜单
     *
     * @param menuVO
     */
    public void updateMenu(MenuVO menuVO, UserBO userBO) {
        MenuBO menuBO = new MenuBO();
        BeanUtils.copyProperties(menuVO, menuBO);
        menuBO.setOperateTime(new Date());
        menuBO.setOperator(userBO.getUsername());
        menuMapper.update(menuBO);
    }

    /**
     * 根据菜单编号删除菜单
     *
     * @param codes
     */
    public void deleteMenuByCode(List<String> codes) {
        menuMapper.delete(codes);
    }
}
