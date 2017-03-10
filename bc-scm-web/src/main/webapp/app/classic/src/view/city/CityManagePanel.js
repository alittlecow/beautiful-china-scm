/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-06
 */

/**
 * 城市管理查询页面
 */
Ext.define('app.view.city.CityManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'citymanage',
    controller: 'city',
    viewModel: {
        type: 'city'
    },
    requires: [
        'app.view.city.CityQueryForm',
        'app.view.city.CityGrid',
        'app.view.city.CityInfoWin',


        'app.view.city.CityController',
        'app.view.city.CityWinController',

        'app.view.city.CityViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'cityqueryform'
    },{
        xtype: 'citygrid',
        flex: 1
    }]
});