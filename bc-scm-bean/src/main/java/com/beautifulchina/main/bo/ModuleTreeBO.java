/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.base.BaseBean;

import java.util.List;

/**
 * 模块业务类（供ExtjsTree）
 */
public class ModuleTreeBO extends BaseBean {


    /**
     * 子节点
     */
    private List<ModuleTreeBO> children;

    /**
     * 节点id
     */
    private String id;

    /**
     * 是否子节点
     */
    private boolean leaf;

    /**
     * 节点名
     */
    private String text;

    /**
     * 复选框
     */
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<ModuleTreeBO> getChildren() {
        return children;
    }

    public void setChildren(List<ModuleTreeBO> children) {
        this.children = children;
    }
}
