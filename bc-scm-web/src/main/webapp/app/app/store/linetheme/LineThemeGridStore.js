/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 线路主题管理表格数据存储
 */
Ext.define('app.store.linetheme.LineThemeGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.linethemegridstore',
    autoLoad: false,
    model:'app.model.linetheme.LineThemeModel',
    storeId:'linethemeGridStore',
    proxy : {
        type : 'ajax',
        //
        url : basePath + '/linetheme/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});