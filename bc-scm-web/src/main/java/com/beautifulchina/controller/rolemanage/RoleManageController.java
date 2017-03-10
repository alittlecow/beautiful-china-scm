/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */

package com.beautifulchina.controller.rolemanage;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.main.bo.ModuleTreeBO;
import com.beautifulchina.menu.pojo.Menu;
import com.beautifulchina.rolemanage.bo.RoleBO;
import com.beautifulchina.rolemanage.bo.RoleExtjsBo;
import com.beautifulchina.rolemanage.pojo.Role;
import com.beautifulchina.rolemanage.vo.RoleVO;
import com.beautifulchina.rolemanage.vo.SaveRoleMenuVO;
import com.beautifulchina.service.rolemanage.RoleManageService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 角色管理控制器
 */

@Controller
@RequestMapping(value = "/rolemanage")
public class RoleManageController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(RoleManageController.class);
    @Autowired
    private RoleManageService roleManageService;

    /**
     * 角色管理表格查询
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<RoleBO> getAllRole(RoleVO roleVO,HttpServletRequest request){
        String language = this.getLocal(request);
        roleVO.setLanguage(language);
        Page<RoleBO> page=roleManageService.getAllRole(roleVO);
        return page;
    }

    /**
     * 查询所有角色名和角色代码
     * @return
     */
    @RequestMapping(value = "getAllRoleCodeAndName")
    @ResponseBody
    public List<RoleBO> getAllRoleCodeAndName(String deptCode,HttpServletRequest request){
        String language = this.getLocal(request);
        UserBO userBO = this.getUser(request);
        List<RoleBO> list=roleManageService.getAllRoleCodeAndName(language,userBO);
        return list;
    }

    /**
     * 角色管理模块查询
     * @param roleCode
     * @return
     */
    @RequestMapping(value = "tree")
    @ResponseBody
    public List<ModuleTreeBO> getModuleList(String roleCode,HttpServletRequest request){
        String language = this.getLocal(request);
        List<ModuleTreeBO> list=roleManageService.getModuleList(language);
        logger.info(""+list);
        return list;
    }

    /**
     * 角色管理模块根据roleCode显示tree
     * @param roleCode
     * @return
     */
    @RequestMapping(value = "showTree")
    @ResponseBody
    public List<Menu> getModuleListByRoleCode(String roleCode){
        List<Menu> list =roleManageService.getModuleListByRoleCode(roleCode);
        return list;
    }

    /**
     * 角色管理菜单查询
     * @param moduleId
     * @return
     */
    @RequestMapping(value = "menu")
    @ResponseBody
    public Map getMenuList(String moduleId,String roleCode){
        List<RoleExtjsBo> menuBOList = roleManageService.getMenuList(moduleId,roleCode);
        logger.info(roleCode);
        Map<String,List<RoleExtjsBo>> listMap = new HashMap<String, List<RoleExtjsBo>>();
        listMap.put("treeList",menuBOList);
        return listMap;
    }

    /**
     * 角色新增保存
     * @param rolemanage
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String,Object> saveRole(Role rolemanage,HttpServletRequest request){
        Map<String,Object> result = null;
        try {
            UserBO userBO = this.getUser(request);
            roleManageService.saveRole(rolemanage,userBO);
            result = successResult();
        } catch (RedisException e) {
            logger.error("保存角色信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 角色修改保存
     * @param rolemanage
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> updateRole(Role rolemanage,HttpServletRequest request){
        Map<String,Object> result = null;
        if(ParameterUtil.isBlank(rolemanage.getRoleCode())){
            logger.info("更新角色信息失败",rolemanage.getRoleCode());
            result = failResult("Parameter is null");
            return result;
        }
        try {
            UserBO userBO = this.getUser(request);
            roleManageService.editRole(rolemanage,userBO);
            result = successResult();
        } catch (RedisException e) {
            logger.error("更新角色信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 修改角色菜单
     * @param saveRoleMenuVO
     * @param request
     * @return
     */
    @RequestMapping(value = "saveMenu")
    @ResponseBody
    public Map<String,Object> saveMenu(SaveRoleMenuVO saveRoleMenuVO, HttpServletRequest request){
        Map<String,Object> result = null;
        try {
            UserBO userBO = this.getUser(request);
            roleManageService.addRoleMenu(saveRoleMenuVO,userBO);
            result = successResult();
        } catch (RedisException e) {
            logger.error("保存角色菜单失败",e);
            result = failResult();
        }
        return result;
    }
}
