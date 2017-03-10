/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-10
 */
package com.beautifulchina.service.rolemanage;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.rolemanage.RoleManageMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.main.bo.ModuleTreeBO;
import com.beautifulchina.manager.RedisManager;
import com.beautifulchina.menu.pojo.Menu;
import com.beautifulchina.menu.pojo.Module;
import com.beautifulchina.menu.pojo.Plate;
import com.beautifulchina.rolemanage.bo.RoleBO;
import com.beautifulchina.rolemanage.bo.RoleExtjsBo;
import com.beautifulchina.rolemanage.bo.RoleMenuBO;
import com.beautifulchina.rolemanage.pojo.Role;
import com.beautifulchina.rolemanage.vo.RoleVO;
import com.beautifulchina.rolemanage.vo.SaveRoleMenuVO;
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
 * 角色管理相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleManageService {
    @Autowired
    private RedisManager redisManager;
    @Autowired
    private RoleManageMapper roleManageMapper;

    /**
     * 获取角色信息
     * @param roleVO
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public Page<RoleBO> getAllRole(RoleVO roleVO){
        int count=roleManageMapper.getAllRoleCount();
        List<RoleBO> roleBOList=new ArrayList<RoleBO>();
        if(count>0){
            List<Role> roles=roleManageMapper.getAllRole(roleVO);
            for(Role role:roles){
                RoleBO roleBO=new RoleBO();
                BeanUtils.copyProperties(role, roleBO);
                roleBOList.add(roleBO);
            }
        }
        Page<RoleBO> page = new Page<RoleBO>();
        page.setData(roleBOList);
        page.setTotal(count);
        return page;
    }


    /**
     * 获取所有角色代码和角色名称
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public List<RoleBO> getAllRoleCodeAndName(String language,UserBO userBO){
        RoleBO roleBO = new RoleBO();
        roleBO.setLanguage(language);
        roleBO.setRoleLevel(userBO.getRoleBO().getRoleLevel());
        return roleManageMapper.getAllRoleCodeAndName(roleBO);
    }

    /**
     * 通过角色代码获取角色模块
     * @param roleCode
     * @return
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly =true)
    public List<Menu> getModuleListByRoleCode(String roleCode){
        List<Menu>  menuList = roleManageMapper.getMenuListByRoleCode(roleCode);
        return menuList;
    }


//    /**
//     * 获取所有模块
//     * @return
//     */
//    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly =true)
//    public List<ModuleTreeBO> getModuleList(){
//        //Extjs树节点集合
//        List<ModuleTreeBO> listBO=new ArrayList<ModuleTreeBO>();
//        //获取所有模板
//        List<Plate> listPlate = roleManageMapper.getPlateList<Plate>();
//        //获取所有模块
//        List<Module> listModule=roleManageMapper.getModuleList();
//
//        //获取所有菜单  传参为空 表示不带条件
//        List<Menu>  menuList = roleManageMapper.getMenuList(null);
//        if(!CollectionUtils.isEmpty(list)){
//            for(Module module:listPlate){
//                List<ModuleTreeBO> childList = new ArrayList<ModuleTreeBO>();
//                ModuleTreeBO moduleBO = new ModuleTreeBO();
//                moduleBO.setId(module.getCode());
//                moduleBO.setText(module.getEnName());
//                moduleBO.setLeaf(false);
//                moduleBO.setChecked(false);
////                moduleBO.setXtype("rolemanagetree");
//                if(!CollectionUtils.isEmpty(menuList)){
//                    for(Menu menu:menuList){
//                        if(module.getCode().equals(menu.getModuleCode())){
//                            ModuleTreeBO menuBO = new ModuleTreeBO();
//                            menuBO.setId(menu.getCode());
//                            menuBO.setText(menu.getEnName());
//                            menuBO.setLeaf(true);
//                            moduleBO.setChecked(false);
//                            childList.add(menuBO);
//                        }
//                        moduleBO.setChildren(childList);
//                    }
//                }
//                listBO.add(moduleBO);
//            }
//        }
//        return listBO;
//    }

    /**
     * 获取所有模块
     * @return
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly =true)
    public  List<ModuleTreeBO> getModuleList(String language){
        //Extjs树节点集合
        List<ModuleTreeBO> listBO=new ArrayList<ModuleTreeBO>();
        //获取所有模板
        List<Plate> plateList = roleManageMapper.getPlateList(language);
        //获取所有模块
        List<Module> moduleList=roleManageMapper.getModuleList(language);

        //获取所有菜单  传参为空 表示不带条件
        List<Menu>  menuList = roleManageMapper.getMenuList(language);
        if(!CollectionUtils.isEmpty(plateList)){
            for(Plate plate:plateList){
                List<ModuleTreeBO> childList = new ArrayList<ModuleTreeBO>();
                ModuleTreeBO plateBO = new ModuleTreeBO();
                plateBO.setId(plate.getCode());
                plateBO.setText(plate.getPlateName());
                plateBO.setLeaf(false);
                plateBO.setChecked(false);
                if(!CollectionUtils.isEmpty(moduleList)){
                    for(Module module:moduleList){
                        List<ModuleTreeBO> childList2 = new ArrayList<ModuleTreeBO>();
                        if(plate.getCode().equals(module.getPlateCode())){
                            ModuleTreeBO moduleBO = new ModuleTreeBO();
                            moduleBO.setId(module.getCode());
                            moduleBO.setText(module.getModuleName());
                            moduleBO.setLeaf(false);
                            moduleBO.setChecked(false);
                            if(!CollectionUtils.isEmpty(menuList)) {
                                for(Menu menu:menuList){
                                    if(module.getCode().equals(menu.getModuleCode())&&plate.getCode().equals(menu.getPlateCode())){
                                        ModuleTreeBO menuBO = new ModuleTreeBO();
                                        menuBO.setId(menu.getCode());
                                        menuBO.setText(menu.getMenuName());
                                        menuBO.setLeaf(true);
                                        menuBO.setChecked(false);
                                        childList2.add(menuBO);
                                        }
                                     }
                                     moduleBO.setChildren(childList2);
                                     childList.add(moduleBO);
                                  }
                               }
                            plateBO.setChildren(childList);
                        }
                    }
                listBO.add(plateBO);
              }
            }
        return listBO;
    }
    /**
     * 通过模块ID获取角色菜单
     * @param moduleId
     * @return
     */
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly =true)
    public List<RoleExtjsBo> getMenuList(String moduleId,String roleCode){
        List<RoleExtjsBo> menuBOList = new ArrayList<RoleExtjsBo>();
        List<Menu> menuList = roleManageMapper.getMenuList(moduleId);
        List<String> menuCodeList=null;
        if(roleCode!=null){
            menuCodeList=roleManageMapper.getRoleMenu(roleCode);
        }
        if(!CollectionUtils.isEmpty(menuList)){
            for(Menu menu:menuList){
                RoleExtjsBo menuBO = new RoleExtjsBo();
                menuBO.setText(menu.getEnName());
                menuBO.setId(menu.getCode());
                menuBO.setLeaf(true);
                menuBO.setCls(menu.getLink());
                if(menuCodeList!=null){
                    for(String menuCode:menuCodeList){
                        if(menu.getCode().equals(menuCode)){
                            menuBO.setChecked(true);
                            break;
                        }
                    }
                }
                menuBOList.add(menuBO);
            }
        }
        return menuBOList;
    }

    /**
     * 保存新增角色信息
     * @param roleManage
     * @throws RedisException
     */
    public void saveRole(Role roleManage,UserBO userBO) throws RedisException {
        String role_level=roleManage.getRoleLevel();
        String[] levels=role_level.split(",");
        StringBuffer level = new StringBuffer("0000");
        for(int i=0;i<levels.length;i++){
            int num=Integer.parseInt(levels[i]);
            level.replace(num-1,num,"1");
        }
        roleManage.setOperateTime(new Date());
        roleManage.setRoleLevel(level.toString());
        //todo
        roleManage.setOperatingPersonnel(userBO.getUsername());
        roleManageMapper.saveRole(roleManage);
    }

    /**
     * 保存修改的角色信息
     * @param roleManage
     * @throws RedisException
     */
    public void editRole(Role roleManage,UserBO userBO) throws RedisException {
        String role_level=roleManage.getRoleLevel();
        String[] levels=role_level.split(",");
        StringBuffer level = new StringBuffer("0000");
        for(int i=0;i<levels.length;i++){
            int num=Integer.parseInt(levels[i]);
            level.replace(num-1,num,"1");
        }
        roleManage.setOperateTime(new Date());
        roleManage.setRoleLevel(level.toString());
        //todo
        roleManage.setOperatingPersonnel(userBO.getUsername());
        roleManageMapper.editRole(roleManage);
    }

    /**
     * 更新角色菜单
     * @param saveRoleMenuVO
     * @param userBO
     */
    public void addRoleMenu(SaveRoleMenuVO saveRoleMenuVO, UserBO userBO) throws RedisException {
        List<RoleMenuBO> roleMenuBOList = new ArrayList<RoleMenuBO>();
        List<RoleMenuBO> roleMenuList = new ArrayList<RoleMenuBO>();
        String roleCode = saveRoleMenuVO.getRoleCode();
        for (String code : saveRoleMenuVO.getMenuCodes()) {
            RoleMenuBO roleMenuBO = new RoleMenuBO();
            roleMenuBO.setRoleCode(roleCode);
            roleMenuBO.setMenuCode(code);
            roleMenuBO.setLoginName(userBO.getUsername());
            roleMenuBO.setOperateTime(new Date());
            roleMenuBOList.add(roleMenuBO);
        }
            roleManageMapper.delRoleMenu(roleCode);
          //按照50个对象一次批量插入 先判断集合长度是否满足50个
        int max = 5;
        int size = roleMenuBOList.size();
        //if(size>max){
            //次数为长度/max 返回int 来决定循环几次
        if(size/max>1){
            for(int i=0;i<size/max;i++){

                if(i==size/max-1){
                    roleMenuList=roleMenuBOList.subList(max*i,size);
                }else {
                    //截取
                    roleMenuList=roleMenuBOList.subList(max*i,max+(max*i));
                }
                System.out.println(max*i+"-----"+((max-1)+(max*i)));
                //插入
                roleManageMapper.addRoleMenu(roleMenuList);

            }
        }else{
            roleManageMapper.addRoleMenu(roleMenuBOList);
        }
    }
}


