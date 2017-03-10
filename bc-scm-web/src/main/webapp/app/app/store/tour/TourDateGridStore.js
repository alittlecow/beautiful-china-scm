/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 线路出发管理表格store
 * @author: dongjingjun
 * date: 2015-12-23
 */

Ext.define('app.store.tour.TourDateGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.tourdategridstore',
    autoLoad: false,
    model:'app.model.tour.TourDateModel',
    storeId:'tourDateGridStore',

    proxy : {
        type : 'ajax',
        url : basePath + '/tourdate/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});