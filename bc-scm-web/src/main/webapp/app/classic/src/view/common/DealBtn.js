/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-29
 */

/**
 * 处理按钮
 */
Ext.define('app.view.common.DealBtn', {
    extend: 'app.view.base.BaseBtn',
    xtype:'dealbtn',
    iconCls:"x-fa fa-reply-all",
    bind:{
        text:'{deal}'
    }
});