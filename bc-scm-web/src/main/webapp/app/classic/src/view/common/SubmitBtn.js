/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-29
 */

/**
 * 提交按钮
 */
Ext.define('app.view.common.SubmitBtn', {
    extend: 'app.view.base.BaseBtn',
    xtype:'submitbtn',
    iconCls:"x-fa fa-reply-all",
    bind:{
        text:'{submit}'
    }
});