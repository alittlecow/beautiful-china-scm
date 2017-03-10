/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 *
 * 系统配置表格存储
 * @author: liufei
 * date: 2015-12-10
 */
Ext.define('app.store.syscfg.SysCfgGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.syscfggridstore',
    autoLoad: false,
    model:'app.model.syscfg.SysCfgModel',
    storeId:'syscfgGridStore',
    proxy : {
        type : 'ajax',
        url : basePath + '/syscfg/query',
        reader:{
            type:'json',
            rootProperty:'data',
            totalProperty:'total'
        }
    }
});