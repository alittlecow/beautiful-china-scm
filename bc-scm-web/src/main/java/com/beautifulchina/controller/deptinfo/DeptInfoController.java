/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.controller.deptinfo;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.deptinfo.bo.DeptBO;
import com.beautifulchina.deptinfo.bo.DeptExtjsBO;
import com.beautifulchina.deptinfo.pojo.Dept;
import com.beautifulchina.deptinfo.vo.DeptVO;
import com.beautifulchina.service.deptinfo.DeptInfoService;
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
 * 部门信息管理控制器
 */
@Controller
@RequestMapping(value = "/deptinfo")
public class DeptInfoController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(DeptInfoController.class);
    @Autowired
    private DeptInfoService deptInfoService;

    /**
     * 获取部门树数据
     * @param code
     * @return
     */
    @RequestMapping(value="tree")
    @ResponseBody
    public List<DeptExtjsBO> getDept(String code,HttpServletRequest request){
        DeptVO deptVO=new DeptVO();
        String language = this.getLocal(request);
        deptVO.setLanguage(language);
        deptVO.setDeptCode(code);
        List<DeptExtjsBO> rootDeptExtjsBOList=deptInfoService.getDept(deptVO);
        return rootDeptExtjsBOList;
    }

    /**
     * 获取所有部门编码和部门名称
     * @return
     */
    @RequestMapping(value="getAllDeptCodeAndDeptName")
    @ResponseBody
    public List<DeptBO> getAllDeptCodeAndDeptName(HttpServletRequest request){
        String language = this.getLocal(request);
        UserBO userBO = this.getUser(request);
        List<DeptBO> codeNameList=deptInfoService.getAllDeptCodeAndDeptName(language,userBO);
        return codeNameList;
    }


    /**
     * 根据id获取部门信息
     * @param deptVO
     * @return
     */
    @RequestMapping(value="form")
    @ResponseBody
    public List<Dept> getForm(DeptVO deptVO){
        List<Dept> list=deptInfoService.getDeptById(deptVO);
        return list;
    }

    /**
     * 根据部门id删除部门信息及其子部门信息
     * @param id
     * @return
     */
    @RequestMapping(value="delDept")
    @ResponseBody
    public Map<String,Object> delDeptById(String id){
        Map<String,Object> result = null;
        if(ParameterUtil.isBlank(id)){
            logger.info("删除部门信息失败",id);
            result=failResult("Parameter is null");
            return result;
        }
        try{
            deptInfoService.delDeptById(id);
            result = successResult();
        }catch (Exception e){
            logger.error("删除部门信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 获取部门代码与名称
     * @return
     */
    @RequestMapping(value="getDeptCN")
    @ResponseBody
    public List<Map> getDeptCN(HttpServletRequest request,String levelCode){
        String language = this.getLocal(request);
        List<Dept> list=deptInfoService.getDeptCN(language,levelCode);
        List<Map> listMap=new ArrayList<Map>();
        for(Dept dept:list){
            Map<String,String> map = new HashMap<String, String>();
            map.put("deptCode",dept.getDeptCode());
            map.put("deptName",dept.getDeptName());
            listMap.add(map);
        }
        return listMap;
    }

    /**
     * 新增部门信息
     * @param deptVO
     * @return
     */
    @RequestMapping(value="addDept")
    @ResponseBody
    public Map<String,Object> addDept(DeptVO deptVO,HttpServletRequest request){
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            deptInfoService.addDept(deptVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("新增部门信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 修改部门信息
     * @param deptVO
     * @return
     */
    @RequestMapping(value="editDept")
    @ResponseBody
    public Map<String,Object> editDept(DeptVO deptVO,HttpServletRequest request){
        Map<String,Object> result = null;
        if(ParameterUtil.isBlank(deptVO.getDeptCode())){
            logger.info("修改部门信息失败",deptVO.getDeptCode());
            result=failResult("Parameter is null");
            return result;
        }
        try{
            UserBO userBO = this.getUser(request);
            deptInfoService.editDept(deptVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("修改部门信息失败",e);
            result = failResult();
        }
        return result;
    }
    @RequestMapping(value="getLevelTree")
    @ResponseBody
    public List<DeptExtjsBO> getLevelTree(HttpServletRequest request){
        String language=this.getLocal(request);
        return deptInfoService.getLevelTree(language);
    }

}
