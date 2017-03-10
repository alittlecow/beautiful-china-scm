/**
 * Copyright @ 2015 南京网华信息科技有限公司.
 * All right reserved.
 * @author: chenghuanhuan
 * date: 15/12/31
 */
Ext.define('app.store.common.CityStore', {
    extend: 'Ext.data.Store',
    alias: 'store.citystore',
    storeId:'cityStore',
    fields:["citId","cityName"],
    pageSize:3,
    proxy: {
        type: 'ajax',
        url: '/common/queryCity',
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        }
    }
    //,
    /*listeners: {
        beforeload: 'onBeforeLoad',
        scope: 'this'
    },*/

    /*privates: {
        onBeforeLoad: function() {

        }
    }*/
});