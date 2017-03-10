/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-11
 */
Ext.define('app.store.order.OrderOptionStore', {
    extend: 'Ext.data.Store',
    alias: 'store.orderoptionstore',
    autoLoad: false,
    storeId: 'orderOptionStore',
    fields: [
        'name', 'id'
    ],
    proxy: {
        type: 'ajax',
        url: basePath + '/order/getOptionByTourId',
        reader: {
            type: 'json'
        }
    }
});