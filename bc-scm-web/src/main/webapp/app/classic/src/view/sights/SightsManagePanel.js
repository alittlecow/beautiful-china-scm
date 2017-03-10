/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点管理主界面
 * @author: dongjingjun
 * date: 2016-01-05
 */

Ext.define('app.view.sights.SightsManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'sightsmanage',
    controller:'sights',
    viewModel: {
        type: 'sights'
    },
    requires: [
        'app.view.sights.SightsGrid',
        'app.view.sights.SightsQueryForm',
        'app.view.sights.SightsInfoWin',

        'app.view.sights.SightsViewModel',

        'app.view.sights.SightsWinController',
        'app.view.sights.SightsController'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'sightsqueryform'
    }, {
        xtype: 'sightsgrid',
        flex: 1
    }]
});