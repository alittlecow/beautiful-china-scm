/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 目的地表格store
 * @author: dongjingjun
 * date: 2016-01-07
 */

Ext.define('app.store.destination.DesGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.desgridstore',
    autoLoad: false,
    model: 'app.model.destination.DesModel',
    storeId: 'desGridStore',
    proxy: {
        type: 'ajax',
        url: basePath + '/destination/query',
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        }
    }
});