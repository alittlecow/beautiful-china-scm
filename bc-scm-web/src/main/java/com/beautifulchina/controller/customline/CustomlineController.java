/**
 * Copyright @ 2016  nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-1-8
 */
package com.beautifulchina.controller.customline;


import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.constants.CommonEnum;
import com.beautifulchina.customline.bo.CustomlineBO;
import com.beautifulchina.customline.pojo.Customline;
import com.beautifulchina.customline.vo.CustomlineVO;
import com.beautifulchina.destinationday.bo.DestinationDayBO;
import com.beautifulchina.destinationday.pojo.DestinationDay;
import com.beautifulchina.destinationday.vo.DestinationDayVO;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.service.customline.CustomlineService;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *定制线路控制器
 */
@Controller
@RequestMapping(value = "/customline")
public class CustomlineController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(CustomlineController.class);

    @Autowired
    private CustomlineService customlineService;

    /**
     * 查询定制线路列表
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public Page<CustomlineBO> list(CustomlineVO customlineVO,HttpSession session){
        UserBO userBO = (UserBO)session.getAttribute(CommonEnum.SESSION_KEY_USER.getValue());
        customlineVO.setPassId(userBO.getId());
        customlineVO.setPassName(userBO.getName());
        customlineVO.setDealTime(new Date());
        Page<CustomlineBO> page = customlineService.getCustomlineExtjsList(customlineVO);
        return page;
    }



    /**
     * 修改定制线路结果
     * */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(@Valid Customline customline){

        // TODO 权限判断
        Map<String,Object> result = null;
        try{
            customlineService.updateCustomline(customline);
            result = successResult();
        }catch (Exception e){
            logger.error("定制线路修改失败",e);
            result = failResult();
        }
        return result;
    }


    /**
     * 查询城市名和旅游天数
     */
    @RequestMapping(value = "listDay")
    @ResponseBody
    public Page<DestinationDayBO> list(@Valid DestinationDayVO destinationdayVO){
        Page<DestinationDayBO> page = customlineService.getDestinationdayExtjsList(destinationdayVO);
        return page;
    }



    /**
     * 修改城市名和旅游天数
     * */
    @RequestMapping(value = "updateDay")
    @ResponseBody
    public Map<String,Object> update(@Valid DestinationDay destinationday){

        // TODO 权限判断
        Map<String,Object> result = null;
        try{
            customlineService.updateDestinationDay(destinationday);
            result = successResult();
        }catch (Exception e){
            logger.error("定制线路修改失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除城市名和旅游天数
     * @return
     */
    @RequestMapping(value = "deleteDay")
    @ResponseBody
    public Map<String,Object> delete(String ids) throws CommException {
        Map<String,Object> result = null;
        // TODO 权限判断
        if(ParameterUtil.isBlank(ids)){
            logger.info("删除分类管理信息失败 ids={}",ids);
            result = failResult("Parameter is null");
        }
        try{
            customlineService.delete(ids);
            result = successResult();
        }catch (Exception e){
            logger.error("更新分类管理信息失败",e);
            result = failResult();
        }
        return result;
    }


    /**
     * 获取城市列表
     *
     */
    @RequestMapping(value = "getCity")
    @ResponseBody
    public List<Map<String, String>> getCity() {
        List<Map<String, String>> list = customlineService.getCity();
        return list;
    }



    /**
     * 保存城市列表
     * @return
     */
    @RequestMapping(value = "saveCity")
    @ResponseBody
    public Map<String, Object> saveCity(DestinationDayVO destinationDayVO){
        Map<String, Object> result = null;
        try {
            customlineService.addDestinationDay(destinationDayVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("保存行程详情信息失败",e);
            result = failResult();
        }
        return result;
    }

}
