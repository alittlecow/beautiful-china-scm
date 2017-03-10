/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.controller.dlmanage;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.dlmanage.bo.LevelBO;
import com.beautifulchina.dlmanage.vo.LevelVO;
import com.beautifulchina.service.dlmanage.DLManageService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门等级管理控制器
 */
@Controller
@RequestMapping(value = "/departmentlevelmanage")
public class DLManageController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(DLManageController.class);
    @Autowired
    private DLManageService dLManageService;

    /**
     * 获取表格数据及查询
     * @param dLManageVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<LevelBO> getDLMList(LevelVO dLManageVO,HttpServletRequest request){
        String language = this.getLocal(request);
        dLManageVO.setLanguage(language);
        Page<LevelBO> page=dLManageService.getDLMList(dLManageVO);
        return page;
    }

    /**
     * 根据部门等级code删除
     * @param code
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String,Object>  delete(String code){
        Map<String,Object> result;
        if(ParameterUtil.isBlank(code)){
            logger.info("删除部门等级失败",code);
            result=failResult("Parameter is null");
            return result;
        }
        try{
            dLManageService.deleteDepartmentLevelByCode(code);
            result = successResult();
        }catch (Exception e){
            logger.error("删除部门等级失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 保存按钮
     * @param dLManageVO
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String,Object> save(LevelVO dLManageVO,HttpServletRequest request){
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            dLManageService.addDepartmentLevel(dLManageVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("保存部门等级信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 可编辑表格更新按钮
     * @param dLManageVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(LevelVO dLManageVO,HttpServletRequest request){
        Map<String,Object> result = null;
        if(ParameterUtil.isBlank(dLManageVO.getCode())){
            logger.info("更新部门等级失败",dLManageVO.getCode());
            result=failResult("Parameter is null");
            return result;
        }
        try{
            UserBO userBO = this.getUser(request);
            dLManageService.updateDepartmentLevel(dLManageVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("更新部门等级失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 获取上级代码
     * @return
     */
    @RequestMapping(value = "getSupCode")
    @ResponseBody
    public List<Map> getSupCode(){
        List<String> list = dLManageService.getSupCode();
        List<Map> mapList=new ArrayList<Map>();
        for(String code:list){
            Map<String,String> map=new HashMap<String, String>();
            map.put("supCode",code);
            mapList.add(map);
        }
        return mapList;
    }
}
