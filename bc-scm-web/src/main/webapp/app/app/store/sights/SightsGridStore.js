/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 景点store
 * @author: dongjingjun
 * date: 2016-01-05
 */

Ext.define('app.store.sights.SightsGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.sightsgridstore',
    autoLoad: false,
    model:'app.model.sights.SightsModel',
    storeId:'sightsGridStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/sights/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});