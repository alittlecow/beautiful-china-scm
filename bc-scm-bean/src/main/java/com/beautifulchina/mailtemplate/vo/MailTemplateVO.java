/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *邮件模板
 * @author: fengbaitong
 * date: 2015-11-26
 */
package com.beautifulchina.mailtemplate.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 邮件模板业务,MailTemplateVO的父类
 */
public class MailTemplateVO  extends PageQuery {


    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
