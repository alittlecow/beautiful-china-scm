/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-25
 */
package com.beautifulchina.controller.tour;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.constants.CommonEnum;
import com.beautifulchina.service.tour.TourService;
import com.beautifulchina.tour.bo.TourBO;
import com.beautifulchina.tour.pojo.TourOption;
import com.beautifulchina.tour.vo.TourOptionVO;
import com.beautifulchina.tour.vo.TourVO;
import com.beautifulchina.tourdetail.bo.TourDetailBO;
import com.beautifulchina.tourdetail.vo.TourDetailVO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 旅游路线管理控制器
 */
@Controller
@RequestMapping(value = "/tour")
public class TourController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(TourController.class);
    @Autowired
    private TourService tourService;

    /**
     * 根据条件获取线路信息
     *
     * @param tourVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<TourBO> getTour(TourVO tourVO, HttpServletRequest request) {
        UserBO userBO = this.getUser(request);
        String language = this.getLocal(request);
        tourVO.setLanguage(language);
        Page<TourBO> page = tourService.getTour(tourVO, userBO);
        return page;
    }

    /**
     * 根据id获取线路信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getBaseInfoById")
    @ResponseBody
    public Page<TourBO> getBaseInfoById(Integer id) {
        Page<TourBO> page = tourService.getBaseInfoById(id);
        return page;
    }

    /**
     * 根据条件获取行程详细信息
     *
     * @return
     */
    @RequestMapping(value = "queryDetail")
    @ResponseBody
    public Page<TourDetailBO> getTourDetail(String id) {
        Page<TourDetailBO> page = tourService.getTourDetail(id);
        return page;
    }

    /**
     * 根据id删除旅游线路管理信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteTour")
    @ResponseBody
    public Map<String, Object> deleteTour(String[] id, HttpServletRequest request) {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(StringUtils.join(id))) {
            logger.info("删除旅游线路信息失败 id={}", StringUtils.join(id));
            result = failResult("Parameter is null");
            return result;
        }
        try {
            UserBO userBO = this.getUser(request);
            tourService.deleteTour(id, userBO, SERVER_PATH);
            result = successResult();
        } catch (Exception e) {
            logger.error("删除线路信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 获取供应商代码及名称
     *
     * @return
     */
    @RequestMapping(value = "getSup")
    @ResponseBody
    public List<Map<String, String>> getSup() {
        List<Map<String, String>> list = tourService.getSup();
        return list;
    }

    /**
     * 获取线路主题
     *
     * @return
     */
    @RequestMapping(value = "getTheme")
    @ResponseBody
    public List<Map<String, String>> getTheme(HttpServletRequest request) {
        List<Map<String, String>> list = tourService.getTheme(this.getLocal(request));
        return list;
    }

    /**
     * 保存线路图片信息
     *
     * @param tourVO
     * @return
     */
    @RequestMapping(value = "saveImage")
    @ResponseBody
    public Map<String, Object> saveImage(TourVO tourVO) {
        Map<String, Object> result = null;
        try {
            tourService.saveImage(tourVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("保存线路图片失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 新增旅游信息
     *
     * @param tourVO
     * @param request
     * @return
     */
    @RequestMapping(value = "saveBaseInfo")
    @ResponseBody
    public Map<String, Object> addBaseInfo(TourVO tourVO, HttpServletRequest request) {
        Map<String, Object> result = null;
        try {
            UserBO userBO = this.getUser(request);
            Integer tourId = tourService.addBaseInfo(tourVO, userBO);
            result = successResult();
            result.put("tourId", tourId);
        } catch (Exception e) {
            logger.error("保存旅游线路信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新旅游线路信息
     *
     * @param tourVO
     * @param request
     * @return
     */
    @RequestMapping(value = "editBaseInfo")
    @ResponseBody
    public Map<String, Object> editBaseInfo(TourVO tourVO, HttpServletRequest request) {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(tourVO.getCode())) {
            logger.info("更新旅游线路信息失败", tourVO.getCode());
            result = failResult("Parameter is null");
            return result;
        }
        try {
            UserBO userBO = this.getUser(request);
            tourService.editBaseInfo(tourVO, userBO);
            result = successResult();
        } catch (Exception e) {
            logger.error("更新旅游线路信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除行程详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteDetail")
    @ResponseBody
    public Map<String, Object> delDetail(String[] id) {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(StringUtils.join(id))) {
            logger.info("删除行程详情是失败 id={}", StringUtils.join(id));
            result = failResult("Parameter is null");
            return result;
        }
        try {
            tourService.delDetail(id);
            result = successResult();
        } catch (Exception e) {
            logger.error("删除行程详情信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 保存行程详情
     *
     * @param tourDetailVO
     * @return
     */
    @RequestMapping(value = "saveDetail")
    @ResponseBody
    public Map<String, Object> saveDetail(TourDetailVO tourDetailVO) {
        Map<String, Object> result = null;
        try {
            tourService.saveDetail(tourDetailVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("保存行程详情信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新行程详情信息
     *
     * @param tourDetailVO
     * @return
     */
    @RequestMapping(value = "updateDetail")
    @ResponseBody
    public Map<String, Object> editDetail(TourDetailVO tourDetailVO) {
        Map<String, Object> result = null;
        if (ParameterUtil.isBlank(tourDetailVO.getId().toString())) {
            logger.info("更新行程详情是失败", tourDetailVO.getId().toString());
            result = failResult("Parameter is null");
            return result;
        }
        try {
            tourService.editDetail(tourDetailVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("更新行程详情信息失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 上传图片
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "uploadImage")
    @ResponseBody
    public Map<String, Object> uploadImage(HttpServletRequest request) {
        Map<String, Object> result;
        try {
            UserBO userBO = this.getUser(request);
            List<String> realSavePath = tourService.uploadImage(request, userBO, SERVER_PATH);
            result = successResult();
            result.put("success", "true");
            result.put("image", realSavePath);
        } catch (Exception e) {
            logger.error("上传图片失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 根据线路id获取图片地址
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getImageByTourId")
    @ResponseBody
    public Map<String, Object> getImageByTourId(Integer id) {
        Map<String, Object> result;
        try {
            List<Map> savePath = tourService.getImageByTourId(id);
            result = successResult();
            result.put("success", "true");
            result.put("image", savePath);
        } catch (Exception e) {
            logger.error("获取图片失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除用户无用文件
     *
     * @param request
     */
    @RequestMapping(value = "deltemp")
    @ResponseBody
    public void delTemp(HttpServletRequest request) {
        UserBO userBO = this.getUser(request);
        tourService.delTemp(request, userBO, SERVER_PATH);
    }

    /**
     * 获取线路代码
     *
     * @return
     */
    @RequestMapping(value = "getCode")
    @ResponseBody
    public Map<String, Boolean> getTourCode(String code) {
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        Boolean flag = tourService.getTourCode(code);
        result.put("flag", flag);
        return result;
    }

    /**
     * 预览前台页面
     *
     * @return
     */
    @RequestMapping(value = "check")
    @ResponseBody
    public String checkTour(String id) {
        String url = "http://" + CommonEnum.SERVER_HOST.getValue() + "/toursdetail/" + id;
        return url;
    }

    /**
     * 根据id获取线路选项信息
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getTourOption")
    @ResponseBody
    public Page<TourOption> getTourOption(Integer id, HttpServletRequest request) {
        Page<TourOption> page = tourService.getTourOption(id, this.getLocal(request));
        return page;
    }

    /**
     * 获取线路选项信息
     *
     * @return
     */
    @RequestMapping(value = "getOption")
    @ResponseBody
    public List<Map<String, String>> getOption(String query, HttpServletRequest request) {
        List<Map<String, String>> list = tourService.getAllOption(query, this.getLocal(request));
        return list;
    }

    /**
     * 根据选项id获取选项值
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getOptionValueById")
        @ResponseBody
        public List<Map<String, String>> getOptionValueById(Integer id, Integer tourId, HttpServletRequest request) {
        List<Map<String, String>> list = tourService.getOptionValueById(id, tourId, this.getLocal(request));
        return list;
    }

    /**
     * 根据选项id获取选项值
     *
     * @param orderNo,tourId
     * @return
     */
    @RequestMapping(value = "getOptionValueByOrderNo")
    @ResponseBody
    public List<Map<String, String>> getOptionValueByOrderNo(String orderNo, Integer tourId, HttpServletRequest request) {
        List<Map<String, String>> list = tourService.getOptionValueByOrderNo(orderNo, tourId, this.getLocal(request));
        return list;
    }


    /**
     * 根据选项id获取已存在选项值
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "getExistOptionValueById")
    @ResponseBody
    public List<Map<String, String>> getExistOptionValueById(Integer tourId, Integer optionId, HttpServletRequest request) {
        List<Map<String, String>> list = tourService.getExistOptionValueById(tourId, optionId, this.getLocal(request));
        return list;
    }

    /**
     * 根据选项id获取已存在选项值
     *
     * @param tourId,optionId,orderNo
     * @return
     */
    @RequestMapping(value = "getExistOptionValueByOrderNo")
    @ResponseBody
    public List<Map<String, String>> getExistOptionValueByOrderNo(Integer tourId, Integer optionId,String orderNo, HttpServletRequest request) {
        List<Map<String, String>> list = tourService.getExistOptionValueByOrderNo(tourId, optionId, orderNo,this.getLocal(request));
        return list;
    }

    /**
     * 保存选项值
     *
     * @param tourOptionVO
     * @return
     */
    @RequestMapping(value = "saveOption")
    @ResponseBody
    public Map<String, Object> saveOption(TourOptionVO tourOptionVO) {
        Map<String, Object> result;
        try {
            tourService.saveOption(tourOptionVO);
            result = successResult();
        } catch (Exception e) {
            logger.error("保存路线选项失败", e);
            result = failResult();
        }
        return result;
    }

    /**
     * 删除选项值
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "deleteOption")
    @ResponseBody
    public Map<String, Object> deleteOption(String[] ids) {
        Map<String, Object> result;
        if (ids.length <= 0) {
            logger.info("删除选项值失败 ids={}", StringUtils.join(ids));
            result = failResult("Parameter is null");
            return result;
        }
        try {
            tourService.deleteOption(ids);
            result = successResult();
        } catch (Exception e) {
            logger.error("删除选项值失败 ", e);
            result = failResult();
        }
        return result;
    }
}


