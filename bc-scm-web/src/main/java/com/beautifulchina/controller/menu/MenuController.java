/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-18
 */
package com.beautifulchina.controller.menu;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.main.bo.MenuListBO;
import com.beautifulchina.main.bo.ModuleBO;
import com.beautifulchina.main.bo.PlateBO;
import com.beautifulchina.menu.pojo.Menu;
import com.beautifulchina.menu.vo.MenuDeleteVO;
import com.beautifulchina.menu.vo.MenuVO;
import com.beautifulchina.menu.vo.ModuleVO;
import com.beautifulchina.menu.vo.PlateVO;
import com.beautifulchina.service.menu.MenuService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * 菜单管理控制器
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;



    /**
     * 查询菜单列表
     * @param menuVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<MenuListBO> queryMenus(@Valid MenuVO menuVO,HttpServletRequest request){
        String language = this.getLocal(request);
        menuVO.setLanguage(language);
        Page<MenuListBO> page = menuService.getAllMenuList(menuVO);
        return page;
    }

    /**
     * 查询板块列表
     * @return
     */
    @RequestMapping(value = "plates")
    @ResponseBody
    public Page<PlateBO> queryMenus(@Valid PlateVO plateVO,HttpServletRequest request){
        String language = this.getLocal(request);
        plateVO.setLanguage(language);
        Page<PlateBO> page = menuService.getPlateList(plateVO);
        return page;
    }

    /**
     * 查询模块列表
     * @return
     */
    @RequestMapping(value = "modules")
    @ResponseBody
    public Page<ModuleBO> queryModules(@Valid ModuleVO moduleVO,HttpServletRequest request){
        String language = this.getLocal(request);
        Page<ModuleBO> page = menuService.getAllModuleList(language);
        return page;
    }

    /**
     * 根剧模板代码查询模块列表
     * @return
     */
    @RequestMapping(value = "getModuleByPlateCode")
    @ResponseBody
    public Page<Menu> queryModulesByPlateCode(@Valid MenuVO menuVO,HttpServletRequest request){
        String language = this.getLocal(request);
        menuVO.setLanguage(language);
        Page<Menu> page = menuService.getModuleByPlateCode(menuVO);
        return page;
    }

    /**
     * 保存菜单
     * @param menuVO
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String,Object> save(@Valid MenuVO menuVO,HttpServletRequest request){
        Map<String,Object> result;
        /**
         * 所有的Ajax请求自己处理异常返回 参照以下
         */
        try{
            UserBO userBO = this.getUser(request);
            menuService.saveMenu(menuVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("保存菜单失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新菜单信息
     * @param menuVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(@Valid MenuVO menuVO, HttpServletRequest request){
        Map<String,Object> result;
        // 参数校验
        if(ParameterUtil.isBlank(menuVO.getCode())){
            logger.info("删除菜单失败 code={}",menuVO.getCode());
            result = failResult("Parameter is null");
            return result;
        }
        
        /**
         * 所有的Ajax请求自己处理异常返回 参照以下
         */
        try{
            UserBO userBO = this.getUser(request);
            menuService.updateMenu(menuVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("更新菜单失败",e);
            result = failResult();
        }

        return result;
    }


    /**
     * 删除菜单
     * @param menuDeleteVO
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String,Object> delete(@Valid MenuDeleteVO menuDeleteVO) throws CommException {
        Map<String,Object> result;

        if(CollectionUtils.isEmpty(menuDeleteVO.getCodes())){
            logger.info("删除菜单失败 menuDeleteVO={}",menuDeleteVO);
            result = failResult("Parameter is null");
            return result;
        }
        try{
            menuService.deleteMenuByCode(menuDeleteVO.getCodes());
            result = successResult();
        }catch (Exception e){
            logger.error("更新菜单失败",e);
            result = failResult();
        }
        return result;
    }
}
