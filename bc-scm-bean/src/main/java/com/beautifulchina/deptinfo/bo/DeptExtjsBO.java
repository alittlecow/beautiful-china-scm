/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 */
package com.beautifulchina.deptinfo.bo;

import com.beautifulchina.base.BaseBean;

import java.util.List;

/**
 * 部门信息节点
 */

public class DeptExtjsBO extends BaseBean {
    /**
     * 节点id
     */
    private Integer id;

    /**
     * 是否是叶子节点
     */
    /**
     * 节点名称
     */
    private String text;
    /**
     * 子节点
     */
    private List children;
    /**
     * 是否展开
     */
    private Boolean expanded;
    private  String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List children) {
        this.children = children;
    }

    private boolean leaf;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }
}
