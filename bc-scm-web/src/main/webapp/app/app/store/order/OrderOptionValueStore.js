/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-03-11
 */
Ext.define('app.store.order.OrderOptionValueStore', {
    extend: 'Ext.data.Store',
    alias: 'store.orderoptionvaluestore',
    autoLoad: false,
    storeId: 'orderOptionValueStore',
    model: 'app.model.tour.OptionValueModel',
    proxy: {
        type: 'ajax',
        url: basePath + '/tour/getOptionValueByOrderNo',
        reader: {
            type: 'json'
        }
    }
});