/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 部门登记管理主页面
 */
Ext.define('app.view.dlmanage.DLMPanel', {
    extend: 'Ext.container.Container',
    xtype: 'dlm',
    controller: 'dlm',
    viewModel: {
        type: 'dlm'
    },
    requires: [
        'app.view.dlmanage.DLMQueryForm',
        'app.view.dlmanage.DLMGrid',
        'app.view.dlmanage.DLMInfoWin',


        'app.view.dlmanage.DLMController',
        'app.view.dlmanage.DLMWinController',

        'app.view.dlmanage.DLMViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'dlmqueryform'
    }
        , {
            xtype: 'dlmgrid',
            flex: 1
        }
    ]
});