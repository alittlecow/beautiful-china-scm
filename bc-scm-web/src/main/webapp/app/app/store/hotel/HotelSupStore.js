/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店供应商store
 * @author: dongjingjun
 * date: 2016-01-04
 */

Ext.define('app.store.hotel.HotelSupStore', {
    extend: 'Ext.data.Store',
    alias: 'store.hotelsupstore',
    autoLoad: false,
    fields: [
        'deptCode',
        'supName'
    ],
    storeId: 'hotelSupStore',
    proxy: {
        type: 'ajax',
        url: basePath + '/hotel/getSup',
        reader: {
            type: 'json'
        }
    }
});