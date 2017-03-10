/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2016-01-03
 */
package com.beautifulchina.controller.hotel;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.base.Page;
import com.beautifulchina.exception.CommException;
import com.beautifulchina.hotel.bo.HotelBO;
import com.beautifulchina.hotel.vo.HotelVO;
import com.beautifulchina.service.hotel.HotelService;
import com.beautifulchina.user.bo.UserBO;
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
 * 酒店管理控制器
 */
@Controller
@RequestMapping(value = "/hotel")
public class HotelController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(HotelController.class);
    @Autowired
    private HotelService hotelService;

    /**
     * 获取酒店信息
     *
     * @param hotelVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<HotelBO> getHotel(HotelVO hotelVO,HttpServletRequest request) {
        String language = this.getLocal(request);
        hotelVO.setLanguage(language);

        Page<HotelBO> page = hotelService.getHotel(hotelVO);
        return page;
    }

    /**
     * 删除菜单
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> delete(String[] ids) throws CommException {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(StringUtils.join(ids))) {
            logger.info("删除酒店信息失败 ids={}", StringUtils.join(ids));
            result = failResult("Parameter is null");
            return result;
        }
        try {
            hotelService.delHotel(ids);
            result = successResult();
        } catch (Exception e) {
            logger.error("删除酒店信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 获取城市列表
     *
     * @return
     */
    @RequestMapping(value = "getCity")
    @ResponseBody
    public List<Map<String, String>> getCity(HttpServletRequest request) {
        List<Map<String, String>> list = hotelService.getCity(this.getLocal(request));
        return list;
    }

    /**
     * 获取城市列表
     *
     * @return
     */
    @RequestMapping(value = "getSup")
    @ResponseBody
    public List<Map<String, String>> getSup(HttpServletRequest request) {
        List<Map<String, String>> list = hotelService.getSup(this.getLocal(request));
        return list;
    }

    /**
     * 新增酒店信息
     *
     * @param hotelVO
     * @param request
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String, Object> addHotel(HotelVO hotelVO, HttpServletRequest request) {
        Map<String, Object> result;
        try {
            UserBO userBO = this.getUser(request);
            hotelService.addHotel(hotelVO, userBO);
            result = successResult();
        } catch (Exception e) {
            logger.error("保存酒店信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新酒店信息
     *
     * @param hotelVO
     * @param request
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String, Object> updateHotel(HotelVO hotelVO, HttpServletRequest request) {
        Map<String, Object> result;
        if (ParameterUtil.isBlank(hotelVO.getId().toString())) {
            logger.info("更新酒店信息失败 id={}", hotelVO.getId().toString());
            result = failResult("Parameter is null");
            return  result;
        }
        try {
            UserBO userBO = this.getUser(request);
            hotelService.updateHotel(hotelVO, userBO);
            result = successResult();
        } catch (Exception e) {
            logger.error("更新酒店信息失败", e);
            result = failResult();
        }
        return result;
    }

}
