/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: liufei
 * date: 2015-12-11
 *
 * chengxuemin 删除group_id，group_name，添加group_code
 * date: 2016-01-24
 */
package com.beautifulchina.syscfg.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 系统配置
 */
public class SysCfgVO extends PageQuery {
    /**
     * 配置id
     */
    private Integer id;
    /**
     * 配置名称
     */
    private String name;
    /**
     * 配置值
     */
    private String value;
    /**
     * 分组编号
     */
    private String groupCode;
    /**
     * 语言
     */
    private String language;
    /**
     * 多语言
     */
    private String multiLanguage;

    public String getMultiLanguage() {
        return multiLanguage;
    }

    public void setMultiLanguage(String multiLanguage) {
        this.multiLanguage = multiLanguage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
