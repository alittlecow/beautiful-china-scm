/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-22
 */
/**
 *
 * 部门等级管理下拉框store
 */
Ext.define('app.store.dlmanage.DLMStore', {
    extend: 'Ext.data.Store',
    alias: 'store.dlmstore',
    autoLoad: false,
    fileds: [
        'supCode'
    ],
    storeId: 'dLMStore',
    proxy: {
        actionMethods: {
            read: "POST"
        },
        type: 'ajax',
        url: basePath + '/departmentlevelmanage/getSupCode',
        reader: {
            type: 'json'
        }
    }
});