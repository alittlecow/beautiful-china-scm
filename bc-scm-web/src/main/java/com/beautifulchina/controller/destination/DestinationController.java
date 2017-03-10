/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-07
 */
package com.beautifulchina.controller.destination;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.base.Page;
import com.beautifulchina.destination.bo.DestinationBO;
import com.beautifulchina.destination.vo.DestinationDeletePhotoVO;
import com.beautifulchina.destination.vo.DestinationDeleteVO;
import com.beautifulchina.destination.vo.DestinationVO;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.service.destination.DestinationService;
import com.beautifulchina.user.bo.UserBO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 目的地管理控制器
 */
@Controller
@RequestMapping(value = "/destination")
public class DestinationController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(DestinationController.class);
    @Autowired
    private DestinationService destinationService;

    /**
     * 获取目的地信息
     *
     * @param destinationVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<DestinationBO> getDestination(DestinationVO destinationVO, HttpServletRequest request) {
        destinationVO.setLanguage(this.getLocal(request));
        Page<DestinationBO> page = destinationService.getDestination(destinationVO);
        return page;
    }

    /**
     * 根据id删除目的地信息
     *
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delDestination(DestinationDeleteVO destinationDeleteVO) throws CommException {
        Map<String, Object> result;
        if (CollectionUtils.isEmpty(destinationDeleteVO.getIds())) {
            logger.info("删除目的地信息失败 destinationDeleteVO={}", destinationDeleteVO.getIds());
            result = failResult("Parameter is null");
            return result;
        }
        try {
            destinationService.delDestination(destinationDeleteVO, SERVER_PATH);
            result = successResult();
        } catch (Exception e) {
            logger.error("删除目的地信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 新增目的地信息
     *
     * @param request 请求
     * @return map
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String, Object> addDestination(HttpServletRequest request) {
        Map<String, Object> result;
        try {
            UserBO userBO = this.getUser(request);
            destinationService.addDestination(userBO, request, SERVER_PATH, this.getLocal(request));
            result = successResult();
            result.put("success", "true");
        } catch (Exception e) {
            logger.error("保存目的地信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新目的地信息
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> updDestination(HttpServletRequest request) {
        Map<String, Object> result;
        try {
            UserBO userBO = this.getUser(request);
            destinationService.updDestination(userBO, request, SERVER_PATH, this.getLocal(request));
            result = successResult();
            result.put("success", "true");
        } catch (Exception e) {
            logger.error("更新目的地信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除图片
     *
     * @param destinationDeletePhotoVO
     * @return
     */
    @RequestMapping(value = "remove")
    @ResponseBody
    public Map<String, Object> delPhoto(DestinationDeletePhotoVO destinationDeletePhotoVO, HttpServletRequest request) {
        Map<String, Object> result;
        try {
            destinationService.delPhoto(destinationDeletePhotoVO, SERVER_PATH);
            result = successResult();
        } catch (Exception e) {
            logger.error("获取图片信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 根据id获取多语言数据
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getLanguageById")
    @ResponseBody
    public Map<String, Object> getLanguageById(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("data", destinationService.getLanguageById(id,this.getLanguage()));
        return map;
    }
}
