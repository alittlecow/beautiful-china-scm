/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理查询页面
 */
Ext.define('app.view.consulting.ConsultingManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'consultingManage',
    controller: 'consulting',
    viewModel: {
        type: 'consulting'
    },
    requires: [
        'app.view.consulting.ConsultingQueryForm',
        'app.view.consulting.ConsultingGrid',
        'app.view.consulting.ConsultingInfoWin',

        'app.view.consulting.ConsultingController',
        'app.view.consulting.ConsultingWinController',

        'app.view.consulting.ConsultingViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'consultingqueryform'
    },{
        xtype: 'consultinggrid',
        flex: 1
    }]
});