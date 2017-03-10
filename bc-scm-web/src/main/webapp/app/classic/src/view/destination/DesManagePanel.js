/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地管理主界面
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.view.destination.DesManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'destinationmanage',
    controller:'des',
    viewModel: {
        type: 'des'
    },
    requires: [
        'app.view.destination.DesGrid',
        'app.view.destination.DesInfoWin',
        'app.view.destination.DesQueryForm',
        'app.view.destination.PhotoBoxWin',

        'app.view.destination.DesWinController',
        'app.view.destination.DesController',

        'app.view.destination.DesViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items:[{
        xtype:'desqueryform'
    },{
        xtype:'desgrid',
        flex:1
    }]
});