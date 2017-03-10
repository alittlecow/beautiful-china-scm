/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhuhoufeng
 * date: 2016-01-06
 */
package com.beautifulchina.controller.city;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.city.bo.CityBO;
import com.beautifulchina.city.vo.CityDeletePhotoVO;
import com.beautifulchina.city.vo.CityVO;
import com.beautifulchina.common.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.service.city.CityService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;


/**
 * 城市控制器
 */

@Controller
@RequestMapping(value = "/city")
public class CityController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    private CityService cityService;



    /**ss
     * 查询城市
     * @param cityVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<CityBO> queryCities(@Valid CityVO cityVO,HttpServletRequest request){
        String language = this.getLocal(request);
        cityVO.setLanguage(language);
        Page<CityBO> page = cityService.getAllCityList(cityVO);
        return page;
    }

    /**
     * 保存城市管理信息
     * @param request
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String,Object> save(HttpServletRequest request){
        Map<String,Object> result;
        try{
            UserBO userBO = this.getUser(request);
            cityService.saveCity(userBO,request,SERVER_PATH);
            result = successResult();
            result.put("success","true");
        }catch (Exception e){
            logger.error("保存城市管理信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新城市管理信息
     * @param request
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update( HttpServletRequest request){
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            cityService.updateCity(userBO,request,SERVER_PATH);
            result = successResult();
            result.put("success","true");
        }catch (Exception e){
            logger.error("更新城市管理信息失败",e);
            result = failResult();
        }
        return result;
    }


    /**
     * 删除城市管理信息
     * @param cityIds
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String,Object> delete(String cityIds,HttpServletRequest request) throws CommException {
        Map<String,Object> result = null;
        if(ParameterUtil.isBlank(cityIds)){
            logger.info("删除城市信息失败 cityIds={}",cityIds);
            result = failResult("Parameter is null");
        }
        try{
            cityService.deleteCityById(cityIds,request,SERVER_PATH);
            result = successResult();
        }catch (Exception e){
            logger.error("更新城市信息失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除图片
     *
     * @param cityDeletePhotoVO
     * @return
     */
    @RequestMapping(value = "remove")
    @ResponseBody
    public Map<String, Object> delPhoto(CityDeletePhotoVO cityDeletePhotoVO, HttpServletRequest request) {
        Map<String, Object> result;
        try {
            cityService.delPhoto(cityDeletePhotoVO, request,SERVER_PATH);
            result = successResult();
        } catch (Exception e) {
            logger.error("获取图片信息失败", e);
            result = failResult();
        }
        return result;
    }
}
