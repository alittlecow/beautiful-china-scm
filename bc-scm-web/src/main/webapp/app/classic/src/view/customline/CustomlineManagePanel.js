/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 定制线路管理主页面
 * @author: zhangyu
 * date: 2016-1-7
 */


Ext.define('app.view.customline.CustomlineManagePanel',{
    extend: 'Ext.container.Container',
    xtype: 'customlinemanage',
    controller:'customline',
    viewModel:'customline',
    requires: [
        'app.view.customline.CustomlineQueryForm',
        'app.view.customline.CustomlineGrid',
        'app.view.customline.customlineDetailInfoWin',
        'app.view.customline.CustomlineController',
        'app.view.customline.CustomDetailWinController',
        'app.view.customline.CustomlineWinController',

        'app.view.customline.CustomlineInfoWindow',
        'app.view.customline.CustomlineViewModel',
        'app.view.customline.CustomlineDetailGrid'




    ],

    layout: {
        type:'vbox',
        align:'stretch'
    },
    items:[
        {
            xtype:'customlinequeryform'
        },
        {
            xtype:'customlinegrid',
            flex:1
        }

    ]
});