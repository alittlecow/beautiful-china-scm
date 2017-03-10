/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.service.mailtemplate;

import com.beautifulchina.common.Page;
import com.beautifulchina.dao.mailtemplate.MailTemplateMapper;
import com.beautifulchina.exception.RedisException;
import com.beautifulchina.mailtemplate.bo.MailTemplateBO;
import com.beautifulchina.mailtemplate.vo.MailTemplateVO;
import com.beautifulchina.main.bo.*;
import com.beautifulchina.manager.RedisManager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 邮件相关服务
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class MailTemplateService {

    @Autowired
    private MailTemplateMapper mailTemplateMapper;

    /**
     * 获取所有邮件模板列表
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED,readOnly =true)
    public Page<MailTemplateBO> getMailTemplateExtjsList(MailTemplateVO mailTemplateVO){
        int count=mailTemplateMapper.getMailTemplateCount();
        Page<MailTemplateBO> menuListBOPage = new Page<MailTemplateBO>();
        if(count>0){
            List<MailTemplateBO> mailList= mailTemplateMapper.getMailTemplateList(mailTemplateVO);
            menuListBOPage.setData(mailList);
            menuListBOPage.setTotal(count);
        }

        return menuListBOPage;
    }

    /**
     *  保存邮件模板
     *  @param mailTemplateBO
     */

    public void saveMailTemplate(MailTemplateBO mailTemplateBO)throws RedisException{
        mailTemplateMapper.saveMailTemplate(mailTemplateBO);
    }

    /**
     *  更改邮件模板
     *  @param mailTemplateBO
     */
    public void updateMailTemplate(MailTemplateBO mailTemplateBO){
        mailTemplateMapper.updateMailTemplate(mailTemplateBO);
    }


}
