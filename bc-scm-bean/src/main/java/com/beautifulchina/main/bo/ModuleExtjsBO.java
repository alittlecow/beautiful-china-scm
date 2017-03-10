/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
package com.beautifulchina.main.bo;

import com.beautifulchina.menu.vo.ModuleVO;

/**
 * 模块业务类（供Extjs）
 */
public class ModuleExtjsBO extends ModuleVO{
    /**
     * 标题名称
     */
    private String title;

    /**
     * 组件类型
     */
    private String xtype;

    /**
     * 模块代码
     */
    private String itemId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXtype() {
        return xtype;
    }

    public void setXtype(String xtype) {
        this.xtype = xtype;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}
