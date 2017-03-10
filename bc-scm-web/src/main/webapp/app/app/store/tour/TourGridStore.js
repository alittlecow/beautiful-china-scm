/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路管理store
 * @author: dongjingjun
 * date: 2015-12-25
 */

Ext.define('app.store.tour.TourGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.tourgridstore',
    autoLoad: false,
    model:'app.model.tour.TourModel',
    storeId:'tourGridStore',

    proxy : {
        type : 'ajax',
        url : basePath + '/tour/query',
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