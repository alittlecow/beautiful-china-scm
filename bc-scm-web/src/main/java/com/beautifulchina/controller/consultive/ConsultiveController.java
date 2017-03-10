/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2016-01-11
 */

package com.beautifulchina.controller.consultive;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.consultive.vo.ConsultiveVO;
import com.beautifulchina.main.bo.ConsultiveListBO;
import com.beautifulchina.service.consultive.ConsultiveService;
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
 * 咨询管理控制器
 */
@Controller
@RequestMapping(value = "/consultive")
public class ConsultiveController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(ConsultiveController.class);

    @Autowired
    private ConsultiveService consultiveService;

    /**
     * 查询咨询管理信息列表
     * @param consultiveVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<ConsultiveListBO> queryConsultives(@Valid ConsultiveVO consultiveVO,HttpServletRequest request){
        String language=this.getLocal(request);
        UserBO userBO = this.getUser(request);
        consultiveVO.setLanguage(language);
        Page<ConsultiveListBO> page = consultiveService.getAllConsultiveList(consultiveVO,userBO);
        return page;
    }

    /**
     * 提交咨询管理信息
     * @param consultiveVO
     * @return
     */
    @RequestMapping(value = "submit")
    @ResponseBody
    public Map<String,Object> submit(@Valid ConsultiveVO consultiveVO,HttpServletRequest request){
        Map<String,Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            consultiveService.replyConsultive(consultiveVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("提交咨询管理信息",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 关闭:更新咨询管理信息
     * @param consultiveVO
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(@Valid ConsultiveVO consultiveVO, HttpServletRequest request){
        Map<String, Object> result = null;
        try{
            UserBO userBO = this.getUser(request);
            consultiveService.closeConsultive(consultiveVO,userBO);
            result = successResult();
        }catch (Exception e){
            logger.error("关闭:更新咨询管理信息失败",e);
            result = failResult();
        }
        return result;
    }
}