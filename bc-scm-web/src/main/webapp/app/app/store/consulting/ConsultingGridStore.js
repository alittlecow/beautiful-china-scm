/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: chengxuemin
 * date: 2016-01-18
 */

/**
 * 咨询投诉管理表格数据存储
 */
Ext.define('app.store.consulting.ConsultingGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.consultinggridstore',
    autoLoad: false,
    model:'app.model.consulting.ConsultingModel',
    storeId:'consultingGridStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/consulting/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});