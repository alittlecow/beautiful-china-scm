/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游行程详情store
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.store.tour.TourDetailGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.tourdetailgridstore',
    autoLoad: false,
    model:'app.model.tour.TourDetailModel',
    storeId:'tourDetailGridStore',

    proxy : {
        type : 'ajax',
        url : basePath + '/tour/queryDetail',
        actionMethods:{
            read: "POST"
        },
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});