/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-20
 */


/**
 * 订单管理查询页面
 */
Ext.define('app.view.order.OrderManagePanel', {
    extend: 'Ext.container.Container',
    xtype: 'ordermanage',
    controller: 'order',
    viewModel: {
        type: 'order'
    },
    requires: [
        'app.view.order.OrderQueryForm',
        'app.view.order.OrderGrid',
        'app.view.order.OrderOptionGrid',


        'app.view.order.OrderInfoWin',
        'app.view.order.OptionSelectWin',//可选项窗体

        'app.view.order.OrderController',
        'app.view.order.OrderWinController',
        'app.view.order.OrderSelectOptionWinController',//选项窗体控制器


        'app.view.order.OrderViewModel'
    ],

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    items: [{
        xtype: 'orderqueryform'
    },{
        xtype: 'ordergrid',
        flex: 1
    }]
});