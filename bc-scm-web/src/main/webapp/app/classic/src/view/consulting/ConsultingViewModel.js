/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理页面数据模型
 */
Ext.define('app.view.consulting.ConsultingViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.consulting',

    requires: [
        'app.store.consulting.ConsultingGridStore'
    ],

    stores: {
        consultingGridStore:{
            type:'consultinggridstore'
        }
    }
});