/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: fengbaitong
 * date: 2015-12-21
 */
package com.beautifulchina.category.bo;

import com.beautifulchina.base.BaseBean;

import java.util.List;

/**
 * 分类信息节点
 */

public class CategoryExtjsBO extends BaseBean {
    /**
     * 节点id
     */
    private Integer id;

    /**
     * 是否是叶子节点
     */
    private boolean leaf;
    /**
     * 节点名称
     */
    private String text;
    /**
     * 子节点
     */
    private List children;

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
