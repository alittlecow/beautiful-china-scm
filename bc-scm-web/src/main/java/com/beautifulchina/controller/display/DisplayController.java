/**
 * Copyright @ 2016  nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-1-15
 */
package com.beautifulchina.controller.display;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.display.bo.DisplayBO;
import com.beautifulchina.display.vo.DisplayVO;
import com.beautifulchina.indexconfig.pojo.IndexConfig;
import com.beautifulchina.indexconfig.vo.IndexConfigVO;
import com.beautifulchina.service.display.DisplayService;
import com.beautifulchina.user.bo.UserBO;
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
 * 首页展示类型控制器
 */
@Controller
@RequestMapping(value = "/display")
public class DisplayController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(DisplayController.class);

    @Autowired
    private DisplayService displayService;

    /**
     * 查询线路列表
     */
    @RequestMapping(value = "getTourDate")
    @ResponseBody
    public Page<DisplayBO> getTourDate(DisplayVO displayVO, HttpServletRequest request) {
        String language = this.getLocal(request);
        Page<DisplayBO> page = displayService.getTourDate(displayVO, language);
        return page;
    }


    /**
     * 根据id获取线路图片
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getTourImages")
    @ResponseBody
    public List<String> getTourImages(Integer id) {
        List<String> list = displayService.getTourImages(id);
        return list;
    }

    /**
     * 保存图片
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "saveimage")
    @ResponseBody
    public Map<String, Object> saveImage(HttpServletRequest request) {
        Map<String, Object> result;
        try {
            UserBO userBO = this.getUser(request);
            String realSavePath = displayService.saveImage(request, userBO, SERVER_PATH);
            result = successResult();
            result.put("success", "true");
            result.put("image", realSavePath);
            logger.info(realSavePath);
        } catch (Exception e) {
            logger.error("上传图片失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 获取页面banner配置值
     *
     * @return
     */
    @RequestMapping(value = "getDisplayBanner")
    @ResponseBody
    public List<IndexConfig> getDisplayBanner() {
        List<IndexConfig> list = displayService.getDisplayBanner();
        return list;

    }

    /**
     * 获取页面tour配置值
     *
     * @return
     */
    @RequestMapping(value = "getDisplayTour")
    @ResponseBody
    public List<IndexConfig> getDisplayTour(HttpServletRequest request) {
        String language = this.getLocal(request);
        List<IndexConfig> list = displayService.getDisplayTour(language);
        return list;
    }

    @RequestMapping(value = "getDisplayTrip")
    @ResponseBody
    public List<IndexConfig> getDisplayTrip(HttpServletRequest request) {
        String language = this.getLocal(request);
        List<IndexConfig> list = displayService.getDisplayTrip(language);
        return list;
    }

    /**
     * 获取页面theme配置值
     *
     * @return
     */
    @RequestMapping(value = "getDisplayTheme")
    @ResponseBody
    public List<IndexConfig> getDisplayTheme(HttpServletRequest request) {
        String language = this.getLocal(request);
        List<IndexConfig> list = displayService.getDisplayTheme(language);
        return list;
    }

    /**
     * 获取页面city配置值
     *
     * @return
     */
    @RequestMapping(value = "getDisplayCity")
    @ResponseBody
    public List<IndexConfig> getDisplayCity(HttpServletRequest request) {
        String language = this.getLocal(request);
        List<IndexConfig> list = displayService.getDisplayCity(language);
        return list;
    }

    /**
     * 保存页面配置信息
     *
     * @param indexConfigVO
     * @return
     */
    @RequestMapping(value = "saveItemData")
    @ResponseBody
    public Map<String, Object> saveItemData(IndexConfigVO indexConfigVO) {
        Map<String, Object> result = null;
        try {
            Boolean flag = displayService.saveItemData(indexConfigVO);
            result = successResult();
            if (flag) {
                result.put("flag", true);
            } else {
                result.put("flag", false);
            }
        } catch (Exception e) {
            logger.error("保存首页展示banner类型信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除未使用图片
     *
     * @param request
     */
    @RequestMapping(value = "removeUnusedImages")
    @ResponseBody
    public void removeUnusedImages(HttpServletRequest request) {
        UserBO userBO = this.getUser(request);
        displayService.removeUnusedImages(userBO, SERVER_PATH);
    }
}
