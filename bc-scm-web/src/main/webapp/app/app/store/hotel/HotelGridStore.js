/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 酒店管理store
 * @author: dongjingjun
 * date: 2016-01-03
 */

Ext.define('app.store.hotel.HotelGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.hotelgridstore',
    autoLoad: false,
    model:'app.model.hotel.HotelModel',
    storeId:'hotelGridStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/hotel/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});