/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-22
 */

package com.beautifulchina.controller.linetheme;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.linetheme.vo.LineThemeDeletePhotoVO;
import com.beautifulchina.linetheme.vo.LineThemeVO;
import com.beautifulchina.main.bo.LineThemeListBO;
import com.beautifulchina.service.linetheme.LineThemeService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * 线路主题管理控制器
 */
@Controller
@RequestMapping(value = "/linetheme")
public class LineThemeController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(LineThemeController.class);

    @Autowired
    private LineThemeService linethemeService;


    /**
     * 查询线路主题信息列表
     * @param linethemeVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<LineThemeListBO> queryLineThemes(@Valid LineThemeVO linethemeVO,HttpServletRequest request){
        linethemeVO.setLanguage(this.getLocal(request));
        Page<LineThemeListBO> page = linethemeService.getAllLineThemeList(linethemeVO);
        return page;
    }


    /**
     * 保存线路主题信息
     * @param request
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String,Object> save(HttpServletRequest request){
        Map<String,Object> result;
        try{
            UserBO userBO = this.getUser(request);
            linethemeService.saveLineTheme(userBO,request,SERVER_PATH);
            result = successResult();
            result.put("success","true");
        }catch (Exception e){
            logger.error("保存线路主题信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新线路主题信息
     * @param request
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(HttpServletRequest request){
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            linethemeService.updateLineTheme(userBO,request,SERVER_PATH);
            result = successResult();
            result.put("success","true");
        }catch (Exception e){
            logger.error("更新线路主题信息失败",e);
            result = failResult();
        }
        return result;
    }


    /**
     * 删除线路主题信息
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String,Object> delete(String ids,HttpServletRequest request) throws CommException {
        Map<String,Object> result = null;
        // TODO 权限判断
        if(ParameterUtil.isBlank(ids)){
            logger.info("删除线路主题信息失败 ids={}",ids);
            result = failResult("Parameter is null");
        }
        try{
            linethemeService.deleteLineThemeById(ids,request,SERVER_PATH);
            result = successResult();
        }catch (Exception e){
            logger.error("更新线路主题信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除图片
     *
     * @param lineThemeDeletePhotoVO
     * @return
     */
    @RequestMapping(value = "remove")
    @ResponseBody
    public Map<String, Object> delPhoto(LineThemeDeletePhotoVO lineThemeDeletePhotoVO, HttpServletRequest request) {
        Map<String, Object> result;
        try {
            linethemeService.delPhoto(lineThemeDeletePhotoVO, request,SERVER_PATH);
            result = successResult();
        } catch (Exception e) {
            logger.error("获取图片信息失败", e);
            result = failResult();
        }
        return result;
    }
}
