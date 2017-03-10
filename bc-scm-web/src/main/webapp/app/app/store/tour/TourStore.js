/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2016-01-14
 */
/**
 * 线路管理表单store
 */
Ext.define('app.store.tour.TourStore', {
    extend: 'Ext.data.Store',
    alias: 'store.tourstore',
    autoLoad: false,
    model:'app.model.tour.TourModel',
    storeId:'tourStore',

    proxy : {
        type : 'ajax',
        url : basePath + '/tour/getBaseInfoById',
        actionMethods:{
            read: "POST"
        },
        reader:{
            type:'json',
            rootProperty:'data'
        }
    }
});