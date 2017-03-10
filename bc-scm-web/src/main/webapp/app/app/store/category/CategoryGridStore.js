/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2015-12-22
 */

/**
 * 线路主题管理表格数据存储
 */
Ext.define('app.store.category.CategoryGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.categorygridstore',
    autoLoad: false,
    model:'app.model.category.CategoryModel',
    storeId:'categoryGridStore',
    proxy : {
        type : 'ajax',

        url : basePath + '/category/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});