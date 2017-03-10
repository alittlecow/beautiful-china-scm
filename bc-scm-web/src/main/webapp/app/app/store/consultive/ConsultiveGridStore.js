/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-11
 */

/**
 * 咨询管理表格数据存储
 */
Ext.define('app.store.consultive.ConsultiveGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.consultivegridstore',
    autoLoad: false,
    fields: [
        'tourId',
        'tourName',
        'status',
        'email',
        'time',
        'content',
        'type',
        'contentAn'
    ],
    storeId:'consultiveGridStore',
    proxy : {
        type : 'ajax',

        url : basePath + '/consultive/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});