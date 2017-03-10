/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: zhuhoufeng
 * date: 2016-01-20
 */

/**
 * 订单管理表格数据存储
 */
Ext.define('app.store.order.OrderHistoryGridStore', {
    extend: 'app.store.base.BaseStore',
    alias: 'store.orderhistorygridstore',
    autoLoad: false,
    model:'app.model.order.OrderModel',
    storeId:'orderHistoryGridStore',

    proxy : {
        url : basePath + '/order/history'
    }
});