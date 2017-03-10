/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * @author: dongjingjun
 * date: 2015-12-21
 * 部门信息管理主页面
 */

Ext.define('app.view.dimanage.DIMPanel', {

    extend: 'Ext.container.Container',
    xtype: 'dim',
    controller: 'dim',
    viewModel: {
        type: 'dim'
    },
    requires: [
        'app.view.dimanage.DIMController',

        'app.view.dimanage.DIMTreeViewModel',
        'app.view.dimanage.DIMViewModel',

        'app.view.dimanage.DIMFormPanel',
        'app.view.dimanage.DIMTreePanel'
    ],

    layout: {
        type: 'hbox',
        align: 'stretch'
    },
    items: [
        {
            xtype: 'dimtree',
            flex: 2
        },
        {
            xtype: 'formpanel',
            hidden:true,
            flex: 3
        }
    ]
});