/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游线路城市store
 * @author: dongjingjun
 * date: 2015-12-28
 */

Ext.define('app.store.tour.TourCityStore', {
    extend: 'Ext.data.Store',
    alias: 'store.tourcitystore',
    autoLoad: false,
    storeId:'tourCityStore',
    fields:[
        'city',
        'id'
    ],
    proxy : {
        type : 'ajax',
        url : basePath + '/tour/getCity',
        actionMethods:{
            read: "POST"
        },
        reader:{
            type:'json'
        }
    }
});