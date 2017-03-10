/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理城市store
 * @author: dongjingjun
 * date: 2016-01-04
 */

Ext.define('app.store.hotel.HotelCityStore', {
    extend: 'Ext.data.Store',
    alias: 'store.hotelcitystore',
    autoLoad: false,
    fields: [
        'cityId',
        'city'
    ],
    storeId: 'hotelCityStore',
    proxy: {
        type: 'ajax',
        url: basePath + '/hotel/getCity',
        reader: {
            type: 'json'
        }
    }
});