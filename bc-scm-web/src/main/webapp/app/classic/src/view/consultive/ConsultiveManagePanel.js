/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-11
 */

/**
 * 咨询管理查询页面
 */
Ext.define('app.view.consultive.ConsultiveManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'consultiveManagement',
    controller: 'consultive',
    viewModel: {
        type: 'consultive'
    },
    requires: [
        'app.view.consultive.ConsultiveQueryForm',
        'app.view.consultive.ConsultiveGrid',
        'app.view.consultive.ConsultiveController',
        'app.view.consultive.ConsultiveViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [
        {
        xtype: 'consultivequeryform'
    },
        {
        xtype: 'consultivegrid',
        flex: 1
    }
    ]
});