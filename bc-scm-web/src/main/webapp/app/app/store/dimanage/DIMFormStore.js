/**
 * Copyright @ 2015 nanjing wanghua Information Technology Co.,Ltd.
 * All right reserved.
 * @author: dongjingjun
 * date: 2015-12-22
 */
/**
 * 上级部门下拉框store
 */
Ext.define('app.store.dimanage.DIMFormStore', {
    extend: 'Ext.data.Store',
    alias: 'store.dimformstore',
    autoLoad: false,
    storeId: 'dimFormStore',
    fields: [
        'deptCode',
        'deptName'
    ],
    proxy: {
        actionMethods: {
            read: "POST"
        },
        type: 'ajax',
        url: basePath + '/deptinfo/getDeptCN',
        reader: {
            type: 'json'
        }
    }
});