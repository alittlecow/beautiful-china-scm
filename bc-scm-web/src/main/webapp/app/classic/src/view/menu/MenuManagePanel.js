/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 菜单管理主页面
 * @author: chenghuanhuan
 * date: 2015-11-16
 */
Ext.define('app.view.menu.MenuManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'menumanage',
    controller:'menu',
    viewModel: {
        type: 'menu'
    },
    requires: [
        'app.view.menu.MenuQueryForm',
        'app.view.menu.MenuGrid',
        'app.view.menu.MenuInfoWindow',


        'app.view.menu.MenuController',
        'app.view.menu.MenuWindowController',

        'app.view.menu.MenuViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items:[{
        xtype:'menuqueryform'
    },{
        xtype:'menugrid',
        flex:1
    }]
});