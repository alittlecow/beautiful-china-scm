/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 线路主题管理查询页面
 */
Ext.define('app.view.linetheme.LineThemeManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'linethememanager',
    controller: 'linetheme',
    viewModel: {
        type: 'linetheme'
    },
    requires: [
        'app.view.linetheme.LineThemeQueryForm',
        'app.view.linetheme.LineThemeGrid',
        'app.view.linetheme.LineThemeInfoWin',


        'app.view.linetheme.LineThemeController',
        'app.view.linetheme.LineThemeWinController',

        'app.view.linetheme.LineThemeViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'linethemequeryform'
    },{
        xtype: 'linethemegrid',
        flex: 1
    }]
});