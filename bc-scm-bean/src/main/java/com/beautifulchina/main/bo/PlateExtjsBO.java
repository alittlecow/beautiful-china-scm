/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.menu.vo.PlateVO;

/**
 * 板块（供Extjs动态加载）
 */
public class PlateExtjsBO extends PlateVO{
    /**
     * 标题名称
     */
    private String title;

    /**
     * 组件类型(默认为panel)
     */
    private String xtype = "panel";

    /**
     * 板块代码/对应前端编号
     */
    private String itemId;

    private String layout = "fit";

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getXtype() {
        return xtype;
    }

    public void setXtype(String xtype) {
        this.xtype = xtype;
    }
}
