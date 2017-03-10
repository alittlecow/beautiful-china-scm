/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chengxuemin
 * date: 2015-12-24
 */

package com.beautifulchina.category.vo;

import com.beautifulchina.common.PageQuery;

/**
 * 分类管理
 */
public class CategoryVO extends PageQuery {
    /**
     * 分类名称英文
     */
    private String nameEn;

    /**
     * 分类名称法语
     */
    private String nameFr;

    /**
     * 分类编号
     */
    private String code;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 父级分类id
     */
    private Integer parent;

    /**
     * 下级待分配分类编号
     */
    private String subCode;

    /**
     * 分类名称代码
     */
    private String name;

    /**
     * id
     */
    private Integer id;

    /**
     * 父类id
     */
    private Integer parentid;

    /**
     * 父类英文名
     */
    private String parentnameEn;

    /**
     * 父类法文名
     */
    private String parentnameFr;

    /**
     * 父类等级
     */
    private Integer parentlevel;

    /**
     * 标志
     */
    private String flag;

    /**
     * 语言
     */
    private String language;

    public Integer getParentid() { return parentid; }

    public void setParentid(Integer parentid) { this.parentid = parentid; }

    public String getSubCode() { return subCode; }

    public void setSubCode(String subCode) { this.subCode = subCode; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getNameEn() { return nameEn; }

    public void setNameEn(String nameEn) { this.nameEn = nameEn; }

    public String getNameFr() { return nameFr; }

    public void setNameFr(String nameFr) { this.nameFr = nameFr; }

    public String getFlag() { return flag; }

    public void setFlag(String flag) { this.flag = flag; }

    public Integer getLevel() { return level; }

    public void setLevel(Integer level) { this.level = level; }

    public Integer getParent() { return parent; }

    public void setParent(Integer parent) { this.parent = parent; }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getParentnameEn() { return parentnameEn; }

    public void setParentnameEn(String parentnameEn) {
        this.parentnameEn = parentnameEn;
    }

    public String getParentnameFr() {
        return parentnameFr;
    }

    public void setParentnameFr(String parentnameFr) {
        this.parentnameFr = parentnameFr;
    }

    public Integer getParentlevel() { return parentlevel; }

    public void setParentlevel(Integer parentlevel) { this.parentlevel = parentlevel; }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
