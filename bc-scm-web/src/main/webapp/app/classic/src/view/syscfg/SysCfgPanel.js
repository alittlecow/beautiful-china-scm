/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置主页面
 * @author: liufei
 * date: 2015-12-10
 */
Ext.define('app.view.syscfg.SysCfgPanel', {
    extend: 'Ext.container.Container',
    xtype: 'syscfgmanage',
    controller: 'syscfg',
    viewModel: {
        type: 'syscfg'
    },
    requires: [
        'app.view.syscfg.SysCfgQueryForm',
        'app.view.syscfg.SysCfgGrid',
        'app.view.syscfg.SysCfgInfoWindow',

        'app.view.syscfg.SysCfgController',
        'app.view.syscfg.SysCfgWindowController',

        'app.view.syscfg.SysCfgViewModel'
    ],
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        padding: '5 0 0 0',
        xtype: 'syscfgqueryform'
    }, {
        xtype: 'syscfggrid',
        flex: 1
    }]
});