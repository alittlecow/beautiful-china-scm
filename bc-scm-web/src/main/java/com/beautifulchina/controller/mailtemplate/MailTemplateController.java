/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.controller.mailtemplate;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.mailtemplate.bo.MailTemplateBO;
import com.beautifulchina.mailtemplate.vo.MailTemplateVO;
import com.beautifulchina.service.mailtemplate.MailTemplateService;
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
 * 邮件模板管理控制器
 */
@Controller
@RequestMapping(value = "/mailtemplate")
public class MailTemplateController extends BaseController{

    private static Logger logger = LoggerFactory.getLogger(MailTemplateController.class);

    @Autowired
    private MailTemplateService mailTemplateService;


    /**
     * 查询邮件模板列表
     * @param
     * @return
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public Page<MailTemplateBO> manageMailTemplate(@Valid MailTemplateVO mailTemplateVO,HttpServletRequest request){
        String language=this.getLocal(request);

        mailTemplateVO.setLanguage(language);

        Page<MailTemplateBO> page = mailTemplateService.getMailTemplateExtjsList(mailTemplateVO);
         return page;
    }

    /**
     * 保存邮件模板
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String,Object> save(@Valid MailTemplateBO mailTemplateBO){
        // TODO 权限判断
        Map<String,Object> result = null;
        try{
            mailTemplateService.saveMailTemplate(mailTemplateBO);
            result = successResult();
        }catch (Exception e){
            logger.error("保存邮件模板失败",e);
            result = failResult();
        }
        return result;
    }

    /**
     * 更新邮件模板
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public Map<String,Object> update(@Valid MailTemplateBO mailTemplateBO){
        Map<String,Object> result = null;
        // 参数校验
        if(ParameterUtil.isBlank(mailTemplateBO.getName())) {
            logger.info("删除邮件模板失败", mailTemplateBO.getName());
            result = failResult("Parameter is null");
        }
        // TODO 权限判断
        /**
         * Ajax请求，异常处理
         */
        try{
            mailTemplateService.updateMailTemplate(mailTemplateBO);
            result = successResult();
        }catch (Exception e){
            logger.error("更新邮件模板失败",e);
            result = failResult();
        }

        return result;
    }


}
