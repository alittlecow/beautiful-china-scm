/**
 * Copyright @ 2016 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 首页展示类型管理主页面
 * @author: zhangyu
 * date: 2016-1-15
 */


Ext.define('app.view.display.DisplayManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'displaymanage',
    controller: 'display',
    viewModel: {
        type: 'display'
    },
    listeners:{
        destroy:'removeUnusedImages'
    },
    scrollable: true,
    requires: [
        'app.view.display.DisplayTripGrid',
        'app.view.display.DisplayTourGrid',
        'app.view.display.DisplayThemeGrid',
        //显示城市配置表格
        'app.view.display.DisplayCityGrid',
        'app.view.display.DisplayBannerGrid',
        'app.view.display.DisplayController',
        'app.view.display.DisplayViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    defaults:{
        padding:'5 0 5 0'
    },
    items: [
        {
            xtype: 'displaybannergrid'
        }
        ,
        {
            xtype: 'displaytourgrid'
        }
        ,
        {
            xtype: 'displaythemegrid'
        }
        ,
        {
            xtype: 'displaytripgrid'
        }
        ,
        {
            xtype: 'displaycitygrid'
        }
    ]
});