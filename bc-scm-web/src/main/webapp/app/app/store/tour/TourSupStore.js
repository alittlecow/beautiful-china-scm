/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 供应商名称store
 * @author: dongjingjun
 * date: 2015-12-28
 */

Ext.define('app.store.tour.TourSupStore', {
    extend: 'Ext.data.Store',
    alias: 'store.toursupstore',
    autoLoad: false,
    storeId:'tourSupStore',
    fields:[
        'name',
        'code'
    ],
    proxy : {
        type : 'ajax',
        url : basePath + '/tour/getSup',
        actionMethods:{
            read: "POST"
        },
        reader:{
            type:'json'
        }
    }
});