/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-11-26
 */
package com.beautifulchina.mailtemplate.bo;

import com.beautifulchina.mailtemplate.vo.MailTemplateVO;

import java.util.Date;

/**
 * 邮件模板业务
 */
public class MailTemplateBO extends MailTemplateVO {

    private int id;
    private String name;

    /**
     * 英文标题
     */
    private String titleEn;

    /**
     * 法文标题
     */
    private String titleFr;

    /**
     * 标题
     */

    private String title;

    /**
     * 英文内容
     */
    private String contentEn;

    /**
     * 法文内容
     */
    private String contentFr;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }

    public String getTitleFr() {
        return titleFr;
    }

    public void setTitleFr(String titleFr) {
        this.titleFr = titleFr;
    }

    public String getContentEn() {
        return contentEn;
    }

    public void setContentEn(String contentEn) {
        this.contentEn = contentEn;
    }

    public String getContentFr() {
        return contentFr;
    }

    public void setContentFr(String contentFr) {
        this.contentFr = contentFr;
    }
}
