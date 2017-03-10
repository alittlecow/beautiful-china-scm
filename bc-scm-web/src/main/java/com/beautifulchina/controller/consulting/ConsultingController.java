/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-18
 */

package com.beautifulchina.controller.consulting;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.consulting.vo.ConsultingVO;
import com.beautifulchina.main.bo.ConsultingListBO;
import com.beautifulchina.service.consulting.ConsultingService;
import com.beautifulchina.user.bo.UserBO;
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
 * 咨询投诉管理控制器
 */
@Controller
@RequestMapping(value = "/consulting")
public class ConsultingController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(ConsultingController.class);

    @Autowired
    private ConsultingService consultingService;

    /**
     * 查询咨询投诉管理信息列表
     * @param consultingVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<ConsultingListBO> queryConsultings(@Valid ConsultingVO consultingVO){
        Page<ConsultingListBO> page = consultingService.getAllConsultingList(consultingVO);
        return page;
    }

    /**
     * 提交咨询管理信息
     * @param consultingVO
     * @return
     */
    @RequestMapping(value = "submit")
    @ResponseBody
    public Map<String,Object> submit(@Valid ConsultingVO consultingVO, HttpServletRequest request){
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            consultingService.submitConsulting(consultingVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("提交咨询管理信息",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 处理咨询管理信息
     * @param consultingVO
     * @return
     */
    @RequestMapping(value = "dispose")
    @ResponseBody
    public Map<String,Object> deal(@Valid ConsultingVO consultingVO, HttpServletRequest request){
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            consultingService.dealConsulting(consultingVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("处理咨询管理信息",e);
            result = failResult();
        }
        return result;
    }
}
