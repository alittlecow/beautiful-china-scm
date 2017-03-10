/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-29
 */

/**
 * 返回按钮
 */
Ext.define('app.view.common.ReturnBtn', {
    extend: 'app.view.base.BaseBtn',
    xtype:'returnbtn',
    iconCls:"x-fa fa-reply-all",
    bind:{
        text:'{returnBtn}'
    }
});