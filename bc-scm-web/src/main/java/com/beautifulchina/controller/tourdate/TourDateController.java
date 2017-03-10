/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-23
 */
package com.beautifulchina.controller.tourdate;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.service.tourdate.TourDateService;
import com.beautifulchina.tourdate.bo.TourDateBO;
import com.beautifulchina.tourdate.vo.TourDateVO;
import com.beautifulchina.user.bo.UserBO;
import com.beautifulchina.util.ParameterUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.context.support.UiApplicationContextUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 线路出发管理控制器
 */
@Controller
@RequestMapping(value = "/tourdate")
public class TourDateController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(TourDateController.class);
    @Autowired
    private TourDateService tourDateService;

    /**
     * 根据条件获取线路出发管理信息
     *
     * @param tourDateBO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<TourDateBO> getTourDate(TourDateBO tourDateBO, HttpServletRequest request) {
        String language = this.getLocal(request);
        tourDateBO.setLanguage(language);
        if (language.equals("en")) {
            tourDateBO.setTitleEn(tourDateBO.getTitle());
        } else {
            tourDateBO.setTitleFr(tourDateBO.getTitle());
        }
        UserBO userBO = this.getUser(request);
        System.out.println(tourDateBO);
        Page<TourDateBO> page = tourDateService.getTourDate(tourDateBO, userBO);
        return page;
    }

    /**
     * 根据id删除线路出发管理信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(String[] id) {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(StringUtils.join(id))) {
            logger.info("删除线路出团信息失败 id={}", StringUtils.join(id));
            result = failResult("Parameter is null");
            return result;
        }
        try {
            tourDateService.delete(id);
            result = successResult();
        } catch (Exception e) {
            logger.error("删除线路出团信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 获取线路名称
     *
     * @return
     */
    @RequestMapping(value = "title")
    @ResponseBody
    public Page<Map<String, String>> getTitle(HttpServletRequest request) {
        Page<Map<String, String>> page = tourDateService.getTitle(this.getLocal(request), this.getUser(request));
        return page;
    }

    /**
     * 保存新增线路出团信息
     *
     * @param tourDateVO
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String, Object> addTourDate(TourDateVO tourDateVO) {
        Map<String, Object> result = null;
        try {
            tourDateService.addTourDate(tourDateVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("保存线路出团信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新线路出团信息
     *
     * @param tourDateVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> editTourDate(TourDateVO tourDateVO) {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(tourDateVO.getId().toString())) {
            logger.info("更新出团信息失败", tourDateVO.getId().toString());
            result = failResult("Parameter is null");
            return result;
        }
        try {
            tourDateService.upDateTourDate(tourDateVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("更新出团信息失败", e);
            result = failResult();
        }
        return result;
    }
}
