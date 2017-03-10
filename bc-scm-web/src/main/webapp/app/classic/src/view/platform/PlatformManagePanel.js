/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 平台用户管理主页面
 * @author: fengbaitong
 * date: 2015-12-12
 */


Ext.define('app.view.platform.PlatformManagePanel',{
    extend: 'Ext.container.Container',
    xtype: 'platformmanage',
    controller:'platform',
    viewModel:'platform',
    requires: [
        'app.view.platform.PlatformQueryForm',
       'app.view.platform.PlatformGrid',
        'app.view.platform.PlatformController',
        'app.view.platform.PlatformWinController',
        'app.view.platform.PlatformInfoWindow',
        'app.view.platform.PlatformViewModel'

    ],

    layout: {
        type:'vbox',
        align:'stretch'
    },
    items:[
        {
            xtype:'platformqueryform'
        },
        {
            xtype:'platformgrid',
            flex:1
        }
    ]
});