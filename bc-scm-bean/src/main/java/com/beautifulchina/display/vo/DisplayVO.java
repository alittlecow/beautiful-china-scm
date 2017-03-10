/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: zhangyu
 * date: 2016-01-14
 */
package com.beautifulchina.display.vo;

import com.beautifulchina.common.PageQuery;


/**
 * Created by zhangyu on 2016/1/14.
 * 首页显示配置
 */
public class DisplayVO extends PageQuery {
    /**
     * 首页显示配置id
     */
    private Integer Id;
    /**
     * 显示位置说明
     */
    private String code;

    /**
     * 供应商名称
     */
    private String supName;

    /**
     * 线路名称英文
     */
    private String titleEn;

    /**
     * 城市名称英文
     */
    private String nameEn;

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String getTitleEn() {
        return titleEn;
    }

    public void setTitleEn(String titleEn) {
        this.titleEn = titleEn;
    }
}


