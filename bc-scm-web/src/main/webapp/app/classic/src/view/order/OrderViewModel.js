/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-20
 */

/**
 * 城市管理页面数据模型
 */
Ext.define('app.view.order.OrderViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.order',

    requires: [
        'app.store.order.OrderGridStore',
        'app.store.order.OrderHistoryGridStore',
        'app.store.order.OrderOptionGridStore',
        'app.store.order.OrderOptionValueStore',
        'app.store.order.OrderOptionStore'
    ],

    stores: {
        orderGridStore:{
            type:'ordergridstore'
        },
        orderHistoryGridStore:{
            type:'orderhistorygridstore'
        },
        orderOptionGridStore:{
            type:'orderoptiongridstore'
        },
        orderOptionStore: {
            type: 'orderoptionstore'
        },
        orderOptionValueStore: {
            type: 'orderoptionvaluestore'
        }
    }
});