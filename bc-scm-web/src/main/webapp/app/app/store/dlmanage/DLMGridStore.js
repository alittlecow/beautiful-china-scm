/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-22
 */
/**
 * 部门等级管理store
 */
Ext.define('app.store.dlmanage.DLMGridStore', {
    extend: 'Ext.data.Store',
    alias: 'store.dlmgridstore',
    autoLoad: false,
    model: 'app.model.dlmanage.DLMModel',
    storeId: 'dLMGridStore',
    proxy: {
        type: 'ajax',
        url: basePath + '/departmentlevelmanage/query',
        reader: {
            type: 'json',
            rootProperty: 'data',
            totalProperty: 'total'
        }
    }
});