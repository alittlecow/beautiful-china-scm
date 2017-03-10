/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 线路主题管理页面数据模型
 */
Ext.define('app.view.linetheme.LineThemeViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.linetheme',

    requires: [
        'app.store.linetheme.LineThemeGridStore'
    ],

    stores: {
        linethemeGridStore:{
            type:'linethemegridstore'
        }
    }
});