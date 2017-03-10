/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-11
 */

/**
 * 咨询管理页面数据模型
 */
Ext.define('app.view.consultive.ConsultiveViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.consultive',

    requires: [
        'app.store.consultive.ConsultiveGridStore'
    ],

    stores: {
        consultiveGridStore:{
            type:'consultivegridstore'
        }
    }
});