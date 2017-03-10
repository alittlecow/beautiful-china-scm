/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-17
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.base.BaseBean;

/**
 * 菜单
 */
public class MenuExtjsBO extends BaseBean{
    /**
     * 节点名称
     */
    private String text;

    /**
     * 节点id
     */
    private String id;

    /**
     * 是否是叶子节点
     */
    private boolean leaf;

    /**
     * 该节点所对应的视图，点击时显示
     */
    private String cls;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }
}
