/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地城市store
 * @author: dongjingjun
 * date: 2016-01-06
 */

Ext.define('app.store.sights.SightsDesCityStore', {
    extend: 'Ext.data.Store',
    alias: 'store.sightsdescitystore',
    autoLoad: false,
    fields:[
        'cityNameEn',
        'desCityId'
    ],
    storeId:'sightsDesCityStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/sights/querydescity',
        reader:{
            type:'json'
        }
    }
});