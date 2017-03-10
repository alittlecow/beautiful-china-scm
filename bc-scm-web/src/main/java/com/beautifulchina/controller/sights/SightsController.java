/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-05
 */
package com.beautifulchina.controller.sights;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.base.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.service.sights.SightsService;
import com.beautifulchina.sights.bo.SightsBO;
import com.beautifulchina.sights.vo.SightsVO;
import com.beautifulchina.util.ParameterUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 景点管理控制器
 */
@Controller
@RequestMapping(value = "/sights")
public class SightsController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(SightsController.class);
    @Autowired
    private SightsService sightsService;

    /**
     * 获取景点信息
     *
     * @param sightsVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<SightsBO> getSights(SightsVO sightsVO,HttpServletRequest request) {
        String language = this.getLocal(request);
        sightsVO.setLanguage(language);
        Page<SightsBO> page = sightsService.getSights(sightsVO);
        return page;
    }

    /**
     * 删除景点信息
     *
     * @param ids
     * @return
     * @throws CommException
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delSights(String[] ids) throws CommException {
        Map<String, Object> result;
        if (ids.length <= 0) {
            logger.info("删除景点信息失败 ids={}", StringUtils.join(ids));
            result = failResult("Parameter is null");
            return result;
        }
        try {
            sightsService.delSights(ids);
            result = successResult();
        } catch (Exception e) {
            logger.error("删除景点信息失败 ", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 新增景点信息
     *
     * @param sightsVO
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String, Object> addSights(SightsVO sightsVO) {
        Map<String, Object> result;
        try {
            sightsService.addSights(sightsVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("新增景点信息失败 ", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新菜单信息
     *
     * @param sightsVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> update(SightsVO sightsVO) {
        Map<String, Object> result;
        if (ParameterUtil.isBlank(sightsVO.getId().toString())) {
            logger.info("更新景点信息失败 id={}", sightsVO.getId().toString());
            result = failResult("Parameter is null");
            return result;
        }
        try {
            sightsService.updSights(sightsVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("更新景点信息失败", e);
            result = failResult();
        }
        return result;
    }
    /**
     * 获取目的地城市列表
     *
     * @return
     */
    @RequestMapping(value = "querydescity")
    @ResponseBody
    public List<Map<String, String>> getDesCity(HttpServletRequest request) {
        List<Map<String, String>> list = sightsService.getDesCity(this.getLocal(request));
        return list;
    }
}
