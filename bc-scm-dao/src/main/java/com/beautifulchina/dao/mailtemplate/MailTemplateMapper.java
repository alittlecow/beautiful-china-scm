/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-25
 */
package com.beautifulchina.dao.mailtemplate;

import com.beautifulchina.base.SqlMapper;
import com.beautifulchina.mailtemplate.bo.MailTemplateBO;
import com.beautifulchina.mailtemplate.vo.MailTemplateVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 邮件模板dao
 */
@Repository
public interface MailTemplateMapper extends SqlMapper {
    /**
     * 获取所有邮件模板
     */

     List<MailTemplateBO> getMailTemplateList(MailTemplateVO mailTemplateVO );

    /**
     * 获取邮件模板总数
     */

     int getMailTemplateCount();

    /**
     * /保存插入一条新的邮件模板
     */

     void saveMailTemplate(MailTemplateBO mailTemplateBO);

    /**
     *  更改邮件模板内容
     */

     void updateMailTemplate(MailTemplateBO mailTemplateBO);

    MailTemplateBO getMailTemplateByName(@Param(value = "name") String name);
}
