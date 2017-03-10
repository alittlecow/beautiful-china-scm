/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 旅游主题store
 * @author: dongjingjun
 * date: 2015-12-28
 */

Ext.define('app.store.tour.TourThemeStore', {
    extend: 'Ext.data.Store',
    alias: 'store.tourthemestore',
    autoLoad: false,
    storeId:'tourThemeStore',
    fields:[
        'name',
        'id'
    ],
    proxy : {
        type : 'ajax',
        url : basePath + '/tour/getTheme',
        actionMethods:{
            read: "POST"
        },
        reader:{
            type:'json'
        }
    }
});