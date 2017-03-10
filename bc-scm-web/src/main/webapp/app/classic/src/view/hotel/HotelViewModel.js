/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理数据模型
 * @author: dongjingjun
 * date: 2016-01-03
 */

Ext.define('app.view.hotel.HotelViewModel', {
    extend: 'app.view.base.BaseViewModel',
    alias: 'viewmodel.hotel',

    requires: [
        'app.store.hotel.HotelSupStore',
        'app.store.hotel.HotelGridStore',
        'app.store.hotel.HotelCityStore'
    ],

    stores: {
        hotelGridStore: {
            type: 'hotelgridstore'
        },
        hotelCityStore: {
            type: 'hotelcitystore'
        },
        hotelSupStore: {
            type: 'hotelsupstore'
        }
    }
});