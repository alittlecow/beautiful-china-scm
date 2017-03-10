/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-11
 */
package com.beautifulchina.controller.mailhistory;

import com.beautifulchina.base.BaseController;
import com.beautifulchina.common.Page;
import com.beautifulchina.mailhistory.vo.MailHistoryVO;
import com.beautifulchina.main.bo.MailHistoryListBO;
import com.beautifulchina.service.mailhistory.MailHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
/**
 * 邮件历史记录控制器
 */
@Controller
@RequestMapping(value = "/mailhistory")
//后端的入口，传入参数返回后端的结果
public class MailHistoryController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(MailHistoryController.class);

    @Autowired
    private MailHistoryService mailhistoryService;

    /**
     * 查询邮件列表
     * @param mailhistoryVO
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public Page<MailHistoryListBO> queryMailHistorys(@Valid MailHistoryVO mailhistoryVO){
        Page<MailHistoryListBO> page = mailhistoryService.getAllMailHistoryList(mailhistoryVO);
        return page;
    }
}
